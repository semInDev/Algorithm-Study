package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n15657 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        int[] output = new int[M];
        
        backtracking(N, M, 0, 0, nums, output, sb);
        
        System.out.print(sb);
	}
	
	private static void backtracking(int N, int M, int depth, int preIdx, int[] nums, int[] output, StringBuilder sb) {
		if(depth == M) {
			for(int num : output) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=preIdx; i<N; i++) {
			output[depth] = nums[i];
			backtracking(N, M, depth+1, i, nums, output, sb);
		}
	}

}
