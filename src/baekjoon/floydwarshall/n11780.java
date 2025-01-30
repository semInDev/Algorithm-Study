package baekjoon.floydwarshall;
import java.util.*;
import java.io.*;

public class n11780 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		long INF = 2000000000001L;//100,000*100,000*2+1 -> 오버플로우X
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		long[][] graph = new long[n+1][n+1];
		int[][] nxt = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) continue;
				graph[i][j] = INF;
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[v][w] = Math.min(graph[v][w], c);
			nxt[v][w] = w;
		}
		
		//floyd
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					//graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					if(graph[i][j] > graph[i][k]+graph[k][j]) {
						graph[i][j] = graph[i][k]+graph[k][j];
						nxt[i][j] = nxt[i][k];
					}
				}
			}
		}
		
		//print
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(graph[i][j] == INF) {
					sb.append(0+" ");
				}else {
					sb.append(graph[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(graph[i][j] == INF || graph[i][j]==0) {
					sb.append("0\n");
				}else {
					StringBuilder temp = new StringBuilder();
					int count = 2;
					int index = i;
					temp.append(i+" ");
					while(nxt[index][j]!=j) {
						count++;
						temp.append(nxt[index][j]+" ");
						index = nxt[index][j];
					}
					temp.append(j);
					sb.append(count+" "+temp+"\n");
				}
			}
		}
		System.out.print(sb);
		
	}
}
