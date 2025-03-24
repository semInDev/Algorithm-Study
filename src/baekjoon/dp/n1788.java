package baekjoon.dp;

import java.io.*;

public class n1788 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 0 || N == 1) {
			System.out.println(N);
			System.out.println(N);
			return;
		}
		if(N == -1) {
			System.out.println(1);
			System.out.println(1);
			return;
		}
		
		int[] dp;
		if(N < 0) {
			N = -N;
			dp = new int[N+1];//인덱스가 양수지만, 음수라고 생각할 것
			dp[0]=0; dp[1]=1;
			for(int i=2; i<N+1; i++) {
				dp[i] = (dp[i-2] - dp[i-1])%1000000000;
			}
		}else {
			dp = new int[N+1];
			dp[0]=0; dp[1]=1;
			for(int i=2; i<N+1; i++) {
				dp[i] = (dp[i-2] + dp[i-1])%1000000000;
			}
		}
		
		if(dp[N]>0) {
			System.out.println(1);
			System.out.println(dp[N]);

		}else {
			System.out.println(-1);
			System.out.println(-dp[N]);

		}
	}

}
