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
public class n1865 {
	static ArrayList<Edge> graph;
	static int INF = 52000001;//(2,500*2+200)*10,000+1
	private static boolean bellmanford(int start, int n, int m) {
		int[] dist = new int[n+1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		for(int i=0;i<n;i++) {
			boolean update = false;
			for(int j=0; j<m; j++) {
				Edge edge = graph.get(j);
				if(dist[edge.v]!=INF && dist[edge.w]>dist[edge.v]+edge.cost) {
					dist[edge.w] = dist[edge.v]+edge.cost;
					update = true;
					if(i == n-1)
						return true;//음의 사이클
				}
			}
			if(!update)
				return false;
		}
		return false;
	}
	private static boolean bellmanford(int n, int m) {
		for(int i=1; i<n+1; i++) {
			if(bellmanford(i, n, m))
				return true;
		}
		return false;
	}
 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		while(TC-->0) {
			graph = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				graph.add(new Edge(S, E, T));
				graph.add(new Edge(E, S, T));
			}
			
			for(int i=0; i<W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				graph.add(new Edge(S, E, -T));
				//겹쳐도 됨! -> 벨만포드 로직 상 겹쳐도 상관 없음. 단, 다른 로직에서는 주의해야 함
			}
			
			if(bellmanford(N, 2*M+W)) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
		}
		System.out.print(sb);
	}
}
