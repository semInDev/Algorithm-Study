package baekjoon.dp;

import java.io.*;

public class n2156 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			int mount = Integer.parseInt(br.readLine());
			arr[i] = mount;
		}
		
		int[][] dp = new int[3][n];
		dp[1][0] = arr[0];
		for(int i=1; i<n; i++) {
			dp[0][i] = Math.max(Math.max(dp[0][i-1], dp[1][i-1]),dp[2][i-1]);
			dp[1][i] = dp[0][i-1]+arr[i];
			dp[2][i] = dp[1][i-1]+arr[i];
		}
		System.out.println(Math.max(Math.max(dp[0][n-1], dp[1][n-1]),dp[2][n-1]));
	}

}
