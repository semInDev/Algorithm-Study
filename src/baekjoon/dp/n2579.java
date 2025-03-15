package baekjoon.dp;
import java.io.*;

public class n2579 {
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());//<=300
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[n][3];
		dp[0][1] = arr[0];
		for(int i=1; i<n; i++) {
			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]);//dp[i-1][0]이 max일 수 있나?->딱히, 예외가 없는 것 같음
			dp[i][1] = dp[i-1][0] + arr[i];
			dp[i][2] = dp[i-1][1] + arr[i];
		}
		
		System.out.println(Math.max(dp[n-1][1], dp[n-1][2]));
		br.close();
	}
}
