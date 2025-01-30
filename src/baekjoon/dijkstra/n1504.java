package baekjoon.dijkstra;
import java.util.*;
import java.io.*;

public class n1504 {
	static ArrayList<int[]>[] graph;
	static int INF = 200000001; //200000 * 1000 + 1, 오버플로우X
	private static int dijkstra(int start, int end, int n) {
		if(start == end) {
			return 0;
		}
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];//0은 더미
		Arrays.fill(dist, INF);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		pq.add(new int[] {start, 0});
		dist[start] = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			
			if(visited[cur[0]]) continue;
			visited[cur[0]]=true;
			
			for(int[] nxt : graph[cur[0]]) {
				if(!visited[nxt[0]] && dist[nxt[0]]>dist[cur[0]]+nxt[1]) {
					dist[nxt[0]] = dist[cur[0]]+nxt[1];
					pq.add(new int[] {nxt[0], dist[nxt[0]]});
				}
			}
		}
		if(dist[end]==INF)
			return -1;
		return dist[end];
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
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[v].add(new int[] {w, c});
			graph[w].add(new int[] {v, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int output1 = 0;
		int temp = dijkstra(1, v1, N);
		if(temp == -1) {
			System.out.println(-1);
			return;
		}
		output1+=temp;
		
		temp = dijkstra(v1, v2, N);
		if(temp == -1) {
			System.out.println(-1);
			return;
		}
		output1+=temp;
		
		temp = dijkstra(v2, N, N);
		if(temp == -1) {
			System.out.println(-1);
			return;
		}
		output1+=temp;		
		
		int output2 = 0;
		temp = dijkstra(1, v2, N);
		if(temp == -1) {
			System.out.println(-1);
			return;
		}
		output2+=temp;
		
		temp = dijkstra(v2, v1, N);
		if(temp == -1) {
			System.out.println(-1);
			return;
		}
		output2+=temp;
		
		temp = dijkstra(v1, N, N);
		if(temp == -1) {
			System.out.println(-1);
			return;
		}
		output2+=temp;

		System.out.println(Math.min(output1, output2));
	}

}
