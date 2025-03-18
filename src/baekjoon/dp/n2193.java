package baekjoon.dp;
import java.io.*;

public class n2193 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		/*
		 * if(n==1) { System.out.println(1); return; }
		 */
		int[][] dp = new int[2][n+1];
		dp[0][1] = 0; dp[1][1] = 1;//1만 존재
		for(int i=2; i<n+1; i++) {
			dp[0][i] = dp[0][i-1] + dp[1][i-1];
			dp[1][i] = dp[0][i-1];
		}
		System.out.println(dp[0][n]+dp[1][n]);
	}

}
