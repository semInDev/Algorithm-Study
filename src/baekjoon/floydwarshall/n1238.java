package baekjoon.floydwarshall;
import java.util.*;
import java.io.*;

public class n1238 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[][] graph = new int[N+1][N+1];//0은 더미
		int INF = 1000001; //10,000*100+1, 오버플로우 가능성X
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(i==j) continue;
				graph[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[v][w] = c;
		}
		
		//floyd
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		int maxTotal = 0;//1<=Ti
		for(int i=1; i<N+1; i++) {
			int total = 0;
			total += graph[i][X];
			total += graph[X][i];
			if(maxTotal < total) {
				maxTotal = total;
			}
		}
		
		System.out.println(maxTotal);
	}

}
