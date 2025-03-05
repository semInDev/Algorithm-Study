package icoda.greedy;
import java.util.*;

//O(N*M): N, M <= 100이라 가능
public class ch3_3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int maxValue = -1;
		for(int i=0;i<N; i++) {
			int minValue = 10001;
			for(int j=0;j<M;j++) {
				minValue = Math.min(minValue, sc.nextInt());
			}
			maxValue = Math.max(minValue, maxValue);
		}
		
		System.out.println(maxValue);
		sc.close();
	}
}
