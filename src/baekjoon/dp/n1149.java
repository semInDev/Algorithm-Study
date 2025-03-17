package baekjoon.dp;
import java.io.*;
import java.util.*;

public class n1149 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[3][n];
		for(int i=0;i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());		
			arr[0][i] = R; arr[1][i] = G; arr[2][i] = B;
		}
		int[][] dp = new int[3][n];
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		dp[2][0] = arr[2][0];
		
		for(int i=1; i<n; i++) {
			dp[0][i] = Math.min(dp[1][i-1], dp[2][i-1])+arr[0][i];
			dp[1][i] = Math.min(dp[0][i-1], dp[2][i-1])+arr[1][i];
			dp[2][i] = Math.min(dp[0][i-1], dp[1][i-1])+arr[2][i];
		}
		System.out.println(Math.min(Math.min(dp[0][n-1], dp[1][n-1]), dp[2][n-1]));
	}

}
