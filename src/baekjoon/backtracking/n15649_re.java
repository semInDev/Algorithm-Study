package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class n15649_re {
	static int N;
	static int M;
	static int[] output;
	static boolean[] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        output = new int[M];
        nums = new boolean[N+1];
        
        backtracking(0);
        
        System.out.print(sb);
	}
	
	private static void backtracking(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(output[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<N+1; i++) {
			if(nums[i]) continue;
			output[depth] = i;
			nums[i] = true;
			backtracking(depth+1);
			nums[i] = false;
		}
	}

}
