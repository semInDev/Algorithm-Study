package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15651 {
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
        bfs(0);
        System.out.print(sb);
	}
	private static void bfs(int depth) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			arr[depth] = i+1;
			bfs(depth+1);
		}
	}
}
