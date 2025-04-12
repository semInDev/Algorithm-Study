package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15650 {
	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
 
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        dfs(0);
        System.out.print(sb);
	}
	
	private static void dfs(int depth) {
		if(M == depth) {
			for(int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		if(depth == 0) {
			for(int i=1; i<N+1; i++) {
				arr[depth] = i;
				dfs(depth + 1);
			}
		}
		else {
			for(int i=arr[depth-1]+1; i<N+1; i++) {
				arr[depth] = i;
				dfs(depth + 1);
			}
		}
	}

}
