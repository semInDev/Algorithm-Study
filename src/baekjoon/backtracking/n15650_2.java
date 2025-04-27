package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15650_2 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        visit = new boolean[N];
        bfs(0, 0);
        System.out.print(sb);
	}
	private static void bfs(int depth, int preValue) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = preValue; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i+1;
				bfs(depth+1, i);
				visit[i] = false;
			}
		}
	}
}