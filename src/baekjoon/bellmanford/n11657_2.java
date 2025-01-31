package baekjoon.bellmanford;
import java.io.*;
import java.util.*;

public class n11657_2 {
	static long INF = 60000000001L;
	//6000*10000*500*2 = 60,000,000,000, overflow O
	static ArrayList<int[]> edges;
	static long[] dist;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	private static boolean bellman() {
		for(int i=0; i<N; i++) {
			boolean update = false;
			for(int j=0; j<M; j++) {
				int[] cur = edges.get(j);
				if(dist[cur[0]]!= INF && dist[cur[1]]>dist[cur[0]]+cur[2]) {
					dist[cur[1]] = dist[cur[0]]+cur[2];
					update = true;
					if(i == N-1) {
						return true;
					}
				}
			}
			if(!update)
				break;
		}
		for(int i=2; i<N+1; i++) {
			if(dist[i] == INF) {
				sb.append(-1+"\n");
			}else {
				sb.append(dist[i]+"\n");
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList<>();
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			edges.add(new int[] {A,B,C});
		}
		
		dist[1] = 0;
		if(bellman()) {
			System.out.println(-1);
		}else {
			System.out.print(sb);
		}

	}

}
