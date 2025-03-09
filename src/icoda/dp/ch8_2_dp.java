package icoda.dp;
import java.util.*;

public class ch8_2_dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dx = {5,3,2};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[1000001];
		for(int i=2; i<n+1; i++) {
			dp[i] = dp[i-1] + 1;
			for(int j=0; j<dx.length; j++) {
				if(i%dx[j] == 0) {
					dp[i] = Math.min(dp[i], dp[i/dx[j]]+1);
				}
			}
		}
		System.out.println(dp[n]);
		sc.close();
	}

}
