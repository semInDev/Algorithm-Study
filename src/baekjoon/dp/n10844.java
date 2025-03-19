package baekjoon.dp;

import java.io.*;

public class n10844 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println(9);
			return;
		}
		long[][] dp = new long[10][N+1];
		for(int i=1; i<10; i++) {
			dp[i][1] = 1;
		}
		for(int i=2; i<N+1; i++) {
			dp[0][i] = dp[1][i-1];
			dp[9][i] = dp[8][i-1];
			for(int j=1; j<9; j++) {
				dp[j][i] = (dp[j-1][i-1] + dp[j+1][i-1])%1000000000;
			}
		}
		long output = 0;
		for(int i=0; i<10; i++) {
			output = (output + dp[i][N])%1000000000;//여기에서도 mod 연산 해줘야 함
		}
		System.out.println(output);
	}

}
