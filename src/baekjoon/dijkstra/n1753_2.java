package baekjoon.dijkstra;
import java.util.*;
import java.io.*;

public class n1753_2 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		int INF = 6000001;//300000 * 10 * 2 + 1 -> 오버플로우X
		ArrayList<int[]>[] graph = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] {v, w});//u->v로 가는데 가중치 w
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(visited[cur[0]]) continue;
			visited[cur[0]] = true;
			for(int[] nxt : graph[cur[0]]) {
				if(!visited[nxt[0]] && dist[nxt[0]] > dist[cur[0]] + nxt[1]) {
					dist[nxt[0]] = dist[cur[0]] + nxt[1];
					pq.offer(new int[] {nxt[0], dist[nxt[0]]});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) {
			if(dist[i] == INF) {
				sb.append("INF\n");
			}else {
				sb.append(dist[i]+"\n");
			}
		}
		System.out.print(sb);
	}

}
