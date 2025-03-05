package icoda.greedy;
import java.util.Scanner;

//O(N): N<=100,000
public class ch3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int cnt = 0;
		while(N!=1) {
			if(N % K == 0) {
				N/=K;
			}else {
				N-=1;
			}
			cnt++;
		}
		
		System.out.println(cnt);
		sc.close();
	}

}
