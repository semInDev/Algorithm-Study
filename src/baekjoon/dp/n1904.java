package baekjoon.dp;

import java.io.*;

public class n1904 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1 || N == 2) {
			System.out.println(N);
			return;
		}
		
		int[] dp = new int[N+1];
		dp[1] = 1; dp[2] = 2;
		for(int i=3; i<N+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
		System.out.println(dp[N]);
	}

}
