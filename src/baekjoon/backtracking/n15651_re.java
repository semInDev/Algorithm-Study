package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n15651_re {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] output = new int[M];
        
        backtracking(N, M, 0, output, sb);
        
        System.out.print(sb);
	}
	
	private static void backtracking(int N, int M, int depth, int[] output, StringBuilder sb) {
		if(depth == M) {
			for(int num : output) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			output[depth] = i;
			backtracking(N, M, depth+1, output, sb);
		}
	}

}
