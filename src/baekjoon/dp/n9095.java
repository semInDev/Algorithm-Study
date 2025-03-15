package baekjoon.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* n이 1 이하일 경우, dp[2] 또는 dp[3]을 참조할 때
 * ArrayIndexOutOfBoundsException이 발생
 * */

public class n9095 {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			if(n==1) {
				sb.append(1+"\n");
				continue;
			}else if(n==2) {
				sb.append(2+"\n");
				continue;
			}else if(n==3) {
				sb.append(4+"\n");
				continue;
			}
			
			int[] dp = new int[n+1];
			dp[1] = 1; dp[2] = 2; dp[3] = 4;
			
			for(int i=4; i<n+1; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			sb.append(dp[n]+"\n");
		}
		
		System.out.print(sb);
		br.close();
	}

}
