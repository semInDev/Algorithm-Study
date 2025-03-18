package baekjoon.dp;

import java.io.*;
import java.util.*;

public class n1932 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<i+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[n][n];
		dp[0][0] = arr[0][0];
		for(int i=1; i<n; i++) {
			dp[i][0] = dp[i-1][0] + arr[i][0];
			for(int j=1; j<i; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
			dp[i][i] = dp[i-1][i-1] + arr[i][i];
		}
		
		int output = -1;
		for(int i=0; i<n; i++) {
			if(output < dp[n-1][i])
				output = dp[n-1][i];
		}
		System.out.println(output);
	}

}
