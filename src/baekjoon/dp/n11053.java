package baekjoon.dp;

import java.io.*;
import java.util.*;

public class n11053 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		dp[0] = 1;
		int output = 1;
		for(int i=1; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i]) {
					dp[i] = Math.max(dp[j]+1, dp[i]);
				}
			}
			if(output < dp[i]) {
				output = dp[i];
			}
		}
		
		System.out.println(output);
	}

}
