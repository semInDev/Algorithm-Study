package baekjoon.dijkstra;
import java.io.*;
import java.util.*;

public class n1504_2 {
	static ArrayList<int[]>[] graph;
	static int INF = 400000001;// 200000 * 1000 *2 +1, overflowX
	private static int dijkstra(int start, int end, int n){
		if(start == end) return 0;//v1==1 or v2==N일 때 대비
		
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[1],o2[1]));
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();//여기서 poll할 때 index만 받아도 될 것 같다.
			if(visited[cur[0]]) continue;
			visited[cur[0]] = true;
			for(int[] nxt : graph[cur[0]]) {
				if(!visited[nxt[0]] && dist[nxt[0]] > dist[cur[0]] + nxt[1]) {
					dist[nxt[0]] = dist[cur[0]] + nxt[1];
					pq.offer(new int[] {nxt[0], dist[nxt[0]]});
				}
			}
		}
		if(dist[end] == INF) {
			return -1;
		}
		return dist[end];
	}
	private static int total(int v1, int v2, int N) {
		int output = 0;
		int temp = dijkstra(1, v1, N);
		if(temp==-1)
			return -1;
		output+=temp;
		
		temp = dijkstra(v1, v2, N);
		if(temp==-1)
			return -1;
		output+=temp;
		
		temp = dijkstra(v2, N, N);
		if(temp==-1)
			return -1;
		output+=temp;
		
		return output;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int output1 = total(v1, v2, N);//v1, v2 순서로 진행
		int output2 = total(v2, v1, N);//v2, v1 순서로 진행
		if(output1 == -1) {
			System.out.print(output2);
		}else if(output2 == -1) {
			System.out.print(output1);
		}else {
			System.out.print(Math.min(output1, output2));
		}
	}

}
