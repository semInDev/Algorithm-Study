package baekjoon.bellmanford;
import java.util.*;
import java.io.*;

class Edge{
	int v, w, cost;
	public Edge(int v, int w, int cost) {
		this.v = v;
		this.w = w;
		this.cost = cost;
	}
}

public class n11657 {
	static ArrayList<Edge> graph;
	static long[] dist;
	private static void bellmanford(int n, int m, int start) {
		// 최단경로 갱신
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				Edge cur = graph.get(j);
				if(dist[cur.v] != Long.MAX_VALUE && dist[cur.w] > dist[cur.v] + cur.cost) {
					dist[cur.w] = dist[cur.v] + cur.cost;
					if(i == n-1) {// 음의 사이클 확인하기
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<n+1; i++) {
			if(dist[i] == Long.MAX_VALUE) {
				sb.append("-1\n");
				continue;
			}
			sb.append(dist[i]+"\n");
		}
		System.out.print(sb);
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();
		dist = new long[N+1];
		Arrays.fill(dist, Long.MAX_VALUE);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.add(new Edge(v, w, cost));
		}
		
		dist[1] = 0;
		bellmanford(N, M, 1);
	}

}
