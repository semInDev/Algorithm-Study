package baekjoon.dp;
import java.io.*;
import java.util.*;

public class n11659 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] dp = new int[N+1];//dp[0]은 더미
		dp[1] = Integer.parseInt(st.nextToken());
		for(int i=2; i<N+1; i++) {
			dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			sb.append(dp[J]-dp[I-1]+"\n");//dp[0]=0이라 에러 없음
		}
		
		System.out.print(sb);
	}

}
