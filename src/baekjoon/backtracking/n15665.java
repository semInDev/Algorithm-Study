package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n15665 {
	static int N, M;
	static int[] output;	
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));		
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        output = new int[M];
        
        backtracking(0);
        
        System.out.print(sb);

	}
	
	private static void backtracking(int depth) {
		if(depth == M) {
			for(int num : output) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int preNum = 0;
		for(int i=0; i<N; i++) {
			if(preNum != nums[i]) {
				output[depth] = nums[i];
				preNum = output[depth];
				backtracking(depth+1);
			}
		}
	}

}
