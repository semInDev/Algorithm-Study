package baekjoon.dp;

import java.io.*;
import java.util.*;

public class n2293 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int[] dp = new int[k+1];
		dp[0] = 1;//필요한 케이스에 대해 생각해보기(dp[5-5]를 하게 될 때)
		int coin = arr[0];
		for(int i=1; i<k+1; i++) {
			if(i%coin == 0)
				dp[i] = 1;
		}
		
		for(int i=1; i<n; i++) {
			coin = arr[i];
			for(int j=coin; j<k+1; j++) {
				dp[j] = dp[j] + dp[j-coin];
			}
		}
		
		System.out.println(dp[k]);
	}

}
