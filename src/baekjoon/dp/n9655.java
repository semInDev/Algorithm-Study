package baekjoon.dp;

import java.io.*;
import java.util.*;

public class n9655 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N==1 || N==3 || N==5) {
			System.out.println("SK");
			return;
		}
		if(N==2 || N==4 || N==6) {
			System.out.println("CY");
			return;
		}
		
		int[] dp = new int[N+1];//SK는 1, CY은 2
		dp[1] = dp[3] = 1; dp[2] = dp[4] = dp[6] = 2;
		int turn = 1;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(2); queue.add(4); queue.add(6);
		while(dp[N] == 0) {
			for(int i=0;i<3; i++) {
				int cur = queue.poll()+3;
				if(cur<N+1) {
					dp[cur] = turn;
					queue.add(cur);
				}
			}
			if(turn == 1) turn = 2;
			else turn = 1;
		}
		
		if(dp[N]==1) System.out.println("SK");
		else System.out.println("CY");
	}

}
