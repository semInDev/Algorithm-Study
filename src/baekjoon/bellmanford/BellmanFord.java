package baekjoon.bellmanford;
import java.util.*;
import java.io.*;
/* [bellman ford algorithm]
 * https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-%EB%B2%A8%EB%A7%8C-%ED%8F%AC%EB%93%9CBellman-Ford-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * */

class Edge {
	int v; // 나가는 정점
	int w; // 들어오는 정점
	int cost;

	public Edge(int v, int w, int cost) {
		this.v = v;
		this.w = w;
		this.cost = cost;
	}
}

public class BellmanFord {
	static ArrayList<Edge> graph;
	static final int INF = 1000000000;
	
	//정점의 개수, 간선의 개수, 출발지
	public static boolean bellmanford(int n, int m, int start) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		//정점의 개수만큼 반복
		for (int i = 0; i < n; i++) {
			//간선의 개수만큼 반복
			for (int j = 0; j < m; j++) {
				Edge edge = graph.get(j); //현재 간선
				
				//현재 간선의 들어오는 정점에 대해 비교
				if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
					dist[edge.w] = dist[edge.v] + edge.cost;
				}
			}
		}
		
		//음수 가중치 확인
		for (int i = 0; i < m; i++) {
			Edge edge = graph.get(i); //현재 간선
			
			//현재 간선의 들어오는 정점에 대해 비교 -> 더 작은 값 생기면 음수 사이클 존재
			if (dist[edge.v] != INF && dist[edge.w] > dist[edge.v] + edge.cost) {
				System.out.println("음수 사이클 존재");
				return false;
			}
		}
		
		//출력
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == INF)
				System.out.print("INF ");
			else
				System.out.print(dist[i] + " ");
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
    
    //그래프 입력받기
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 정점의 개수, 간선의 개수 
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		graph = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.add(new Edge(v, w, cost));
		}
		
        //벨만-포드 알고리즘 수행
		bellmanford(n, m, 4);
	}
}
