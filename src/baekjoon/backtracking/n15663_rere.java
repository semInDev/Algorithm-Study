package baekjoon.backtracking;

import java.io.*;
import java.util.*;

public class n15663_rere {
	static int N, M;
	static int[] nums, output;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args)throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());        

        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        output = new int[M];
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        backtracking(0, -1);
        
        System.out.print(sb);
	}

	private static void backtracking(int depth, int preIdx) {
		if(depth == M) {
			for(int num : output) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(preIdx == i || (i+1<N && nums[i] == nums[i+1])) continue;
			output[depth] = nums[i];
			backtracking(depth+1, i);
		}
	}
}
