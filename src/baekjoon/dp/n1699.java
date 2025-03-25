package baekjoon.dp;

import java.io.*;

public class n1699 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		for(int i=1; i<N+1; i++) {
			dp[i] = i;
			if(Math.sqrt(i)%1==0) {
				dp[i] = 1;
				continue;
			}
			for(int j=1; i>j*j; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
			}
		}
		
		System.out.println(dp[N]);
	}

}
