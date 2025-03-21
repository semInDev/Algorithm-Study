package baekjoon.dp;

import java.io.*;

public class n15988 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		long[] dp = new long[1000001];
		dp[1] = 1; dp[2] = 2; dp[3] = 4;
		int count = 3;
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			if(count >= n) {
				sb.append(dp[n]+"\n");
				continue;
			}
			for(int i=count+1; i<n+1; i++) {
				dp[i] = (dp[i-3] + dp[i-2] + dp[i-1])%1000000009;
			}
			sb.append(dp[n]+"\n");
			count = n;
		}
		
		System.out.print(sb);
	}

}
