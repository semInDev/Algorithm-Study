package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class n15649 {

	public static int[] arr;
	public static boolean[] visit;
 
	public static void main(String[] args)throws IOException {
 
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
		arr = new int[M];
		visit = new boolean[N+1];
		dfs(N, M, 0);
 
	}
 
	public static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
 
		for (int i = 1; i < N+1; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i;
				dfs(N, M, depth + 1);
				visit[i] = false;
			}
		}
	}
}
