package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1182 {
	static int N, S, cnt;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));		
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        backtracking(-1, 0);
        
        System.out.println(cnt);
	}
	
	private static void backtracking(int preIdx, int sum) {
		for(int i=preIdx+1; i<N; i++) {
			sum += nums[i];
			if(sum == S) cnt++;
			backtracking(i, sum);
			sum -= nums[i];
		}
	}
}
