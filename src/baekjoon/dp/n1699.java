package baekjoon.dp;

import java.io.*;

public class n1699 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		int max_square = 1;
		dp[1] = 1;
		for(int i=2; i<N+1; i++) {
			if(Math.sqrt(i) % 1 == 0) {
				dp[i] = 1;
				max_square = i;
				continue;
			}
			dp[i] = 1 + dp[i-max_square];
		}
		
		System.out.println(dp[N]);
	}

}
