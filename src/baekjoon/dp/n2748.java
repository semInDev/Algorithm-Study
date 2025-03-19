package baekjoon.dp;

import java.io.*;

public class n2748 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N < 2) {
			System.out.println(N);
			return;
		}
		long[] dp = new long[N+1];
		dp[0] = 0; dp[1] = 1;
		for(int i=2; i<N+1; i++) {
			dp[i] = dp[i-2] + dp[i-1];
		}
		
		System.out.println(dp[N]);
	}

}
