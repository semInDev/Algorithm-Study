package icoda.dp;
import java.util.*;

public class ch8_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<n+1; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[n+1];
		dp[1] = arr[1];
		dp[2] = Math.max(dp[1], arr[2]);
		for(int i=3; i<dp.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i]);
		}
		
		System.out.println(dp[n]);
		sc.close();
	}

}
