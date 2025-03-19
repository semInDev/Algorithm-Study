package baekjoon.dp;

import java.io.*;
import java.util.*;

//overflow 없음. 시간복잡도 O(N^2), N<=15
public class n14501 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[2][N+1];
		StringTokenizer st;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			arr[0][i] = T; arr[1][i] = P;
		}
		
		int[] dp = new int[N+1];
		dp[1] = arr[1][1];
		int output = arr[1][1];
		for(int i=2; i<N+1; i++) {
			if(N-i+1 < arr[0][i])
				continue;//예제 6,7일째 예외처리
			dp[i] = arr[1][i];
			for(int j=1; j<i; j++) {
				if(i - j >= arr[0][j])
					dp[i] = Math.max(dp[j] + arr[1][i], dp[i]);
			}
			if(output < dp[i])
				output = dp[i];
		}
		System.out.println(output);
	}
}
