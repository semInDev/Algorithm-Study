package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class n15654 {
	static int N;
	static int M;
	static int[] nums;
	static int[] arr;
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args)throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken()); 
        }
        Arrays.sort(nums);
        
        arr = new int[M];
        visit = new boolean[N];
        dfs(0);
        System.out.print(sb);
	}
	private static void dfs(int depth) {
		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = nums[i];
				dfs(depth+1);
				visit[i] = false;
			}
		}
	}
}
