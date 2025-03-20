package baekjoon.dp;

import java.io.*;
import java.util.*;

public class n14501 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[2][N+2];
		StringTokenizer st;
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			arr[0][i] = T; arr[1][i] = P;
		}
		
		int[] dp = new int[N+2];//퇴사일: N+1
		int max_value = -1;
		for(int i=1; i<N+2; i++) {
			if(max_value < dp[i])
				max_value = dp[i];
			int nxt = i + arr[0][i];
			if(nxt<N+2)
				dp[nxt] = Math.max(dp[nxt], max_value+arr[1][i]);
		}
		
		System.out.println(dp[N+1]);
	}
}
