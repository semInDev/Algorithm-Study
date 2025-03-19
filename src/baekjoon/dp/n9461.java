package baekjoon.dp;

import java.io.*;

public class n9461 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			if(N==1 || N==2 || N==3) {
				sb.append("1\n");
				continue;
			}
			if(N==4 || N==5) {
				sb.append("2\n");
				continue;
			}
			
			long[] dp = new long[N+1];
			dp[1] = dp[2] = dp[3] = 1;
			dp[4] = dp[5] = 2;
			for(int i=6; i<N+1; i++) {
				dp[i] = dp[i-5] + dp[i-1];
			}
			sb.append(dp[N]+"\n");
		}
		System.out.print(sb);
	}

}
