package baekjoon.dp;
import java.io.*;
import java.util.*;

public class n12852 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		dp[1] = 0;
		int[] arr = new int[n+1];//부모를 기록함
		arr[1] = 1;
		
		for(int i=2; i<n+1; i++){
			dp[i] = dp[i-1] + 1;
			arr[i] = i-1;
			if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
				dp[i] = dp[i/2] + 1;
				arr[i] = i/2;
			}
			if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
				arr[i] = i/3;
			}
		}
		
		int index = n;
		//ArrayList나 Queue
		Queue<Integer> queue = new ArrayDeque<>();
		while(arr[index] != index) {
			queue.add(index);
			index = arr[index];
		}
		
		while(!queue.isEmpty()){
			sb.append(queue.poll()+" ");
		}
		sb.append("1 ");
		
		System.out.println(dp[n]);
		System.out.println(sb);
	}

}
