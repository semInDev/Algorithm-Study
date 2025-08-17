package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n15663_re {

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
        
        boolean[] visited = new boolean[N];
        int[] output = new int[M];
        
        backtracking(N, M, 0, nums, visited, output, sb);
        
        System.out.print(sb);
	}
	
	private static void backtracking(int N, int M, int depth, int[] nums, boolean[] visited, int[] output, StringBuilder sb){
		if(depth == M) {
			for(int num : output) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}
		int preNum = 0;
		for(int i=0; i<N; i++) {
			if(!visited[i] && preNum != nums[i]) {
				visited[i] = true;
				output[depth] = nums[i];
				preNum = output[depth];
				backtracking(N,M,depth+1,nums,visited,output,sb);
				visited[i] = false;
			}
		}
	}
}
