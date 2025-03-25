package baekjoon.dp;

import java.io.*;
import java.util.*;

public class n2294 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[n+1];
		for(int i=1; i<n+1; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[k+1];
		int coin = coins[1];
		for(int i=1; coin*i<=k; i++) {
			dp[coin*i] = i;
		}
		for(int i=2;i<n+1;i++) {
			coin = coins[i];
			for(int j=coin; j<k+1; j++) {
				if(j-coin==0 || dp[j-coin]!=0) {
					if(dp[j]!=0) {
						dp[j] = Math.min(dp[j-coin] + 1, dp[j]);
					}else {
						dp[j] = dp[j-coin] + 1;
					}
				}
			}
		}
		
		if(dp[k]==0) System.out.println(-1);
		else System.out.println(dp[k]);
	}

}
