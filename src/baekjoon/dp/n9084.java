package baekjoon.dp;

import java.io.*;
import java.util.*;

public class n9084 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			
			int[] coins = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int[][] dp = new int[N+1][M+1];
			for(int i=1; i<N+1; i++) {
				dp[i][0] = 1;
			}
			for(int i=1; i<N+1; i++) {
				int coin = coins[i];
				for(int j=1; j<M+1; j++) {
					if(j-coin>=0) dp[i][j] = dp[i][j-coin]+dp[i-1][j];
					else dp[i][j] = dp[i-1][j];
				}
			}
			
			sb.append(dp[N][M]+"\n");
		}
		System.out.print(sb);
	}

}
