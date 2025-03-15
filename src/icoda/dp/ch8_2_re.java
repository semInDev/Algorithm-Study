package icoda.dp;
import java.util.Scanner;

//시간 복잡도: O(30000 * 4)
public class ch8_2_re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dx = {2,3,5};
		
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		
		int[] dp = new int[150001];
		for(int i=2; i<X+1; i++) {
			dp[i] = dp[i-1] + 1;
			for(int j=0; j<dx.length; j++) {
				if(i%dx[j] == 0) {
					dp[i] = Math.min(dp[i/dx[j]] + 1, dp[i]);
				}
			}
		}
		
		System.out.println(dp[X]);
		sc.close();
	}

}
