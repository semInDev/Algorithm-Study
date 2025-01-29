package baekjoon.floydwarshall;
import java.util.*;
import java.io.*;

public class n11404 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] graph = new int[n+1][n+1];//row, col 0은 더미
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) continue;
				graph[i][j] = 10000001;// 100,000 * 100 + 1
			}
		}
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[v][w] = Math.min(graph[v][w], c);
			//https://steady-coding.tistory.com/96
		}
		
		//floyd
		for(int k=1; k<n+1; k++) {
			for(int i=1; i<n+1; i++) {
				for(int j=1; j<n+1; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					//최대로 나올 수 있는 값이 10000001+10000001=20,000,002이므로 오버플로우 발생X
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(graph[i][j] == 10000001) {
					sb.append(0+" ");
				}else {
					sb.append(graph[i][j]+" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}
