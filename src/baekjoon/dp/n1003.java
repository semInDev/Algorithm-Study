package baekjoon.dp;
import java.io.*;

public class n1003 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				sb.append("1 0\n");
				continue;
			}
			if(N == 1) {
				sb.append("0 1\n");
				continue;
			}
			
			int[][] dp = new int[2][N+1];
			dp[0][0] = 1;
			dp[1][1] = 1;
			for(int i=2; i<N+1; i++) {
				dp[0][i] = dp[0][i-1] + dp[0][i-2];
				dp[1][i] = dp[1][i-1] + dp[1][i-2];
			}
			sb.append(dp[0][N]+" "+dp[1][N]+"\n");
		}
		System.out.print(sb);
	}

}
