package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n6603 {
	static int k;
	static int[] S;
	static int[] output = new int[6];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			if(k==0) break;
			
			S = new int[k];
			for(int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			backtracking(0, -1);
			sb.append("\n");
        }
		System.out.print(sb);
	}
	
	private static void backtracking(int depth, int preIdx) {
		if(depth == 6) {
			for(int num : output) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=preIdx+1; i<k; i++) {
			output[depth] = S[i];
			backtracking(depth+1, i);
		}
	}
}
