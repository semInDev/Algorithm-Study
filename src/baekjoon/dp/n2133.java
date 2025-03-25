package baekjoon.dp;

import java.io.*;

public class n2133 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.println(0);
			return;
		}
		if(n==2) {
			System.out.println(3);
			return;
		}
		
		int[] dp = new int[n+1];
		dp[2] = 3;
		for(int i=4; i<n+1; i++) {
			if(i%2==0) {
				dp[i] += dp[i-2] * dp[2];
				for(int j=2; 2*j<i; j++) {
					dp[i] += dp[i-2*j] * 2;
				}
				dp[i]+= 2;
			}
		}
		System.out.println(dp[n]);
	}

}
