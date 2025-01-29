package baekjoon.dijkstra;
import java.util.*;
import java.io.*;

class Node{
	int index;
	int cost;
	
	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}
}

public class n1753 {
	static ArrayList<Node>[] graph;
	static int[] dist;
	static boolean[] visited;
	private static void dijkstra(int n, int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.cost, o2.cost));
		pq.offer(new Node(start, 0));
		while(!pq.isEmpty()) {
			int cur = pq.poll().index;
			if(visited[cur])
				continue;
			visited[cur] = true;
			for(Node next : graph[cur]) {
				if(dist[next.index]>dist[cur] + next.cost) {
					dist[next.index] = dist[cur] + next.cost;
					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		dist = new int[N+1];
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=1; i<N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[v].add(new Node(w, c));
		}
		
		dist[start] = 0;
		dijkstra(N, start);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<N+1; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				sb.append("INF\n");
				continue;
			}
			sb.append(dist[i]+"\n");
		}
		System.out.print(sb);
	}

}
