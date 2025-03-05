package icoda.greedy;
import java.util.*;

public class q1 {
	//O(N)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int cnt = 0;
		int output = 0;
		for(int i : arr) {
			cnt++;
			if(cnt>=i) {
				output++;
				cnt = 0;
			}
		}
		
		System.out.println(output);
		sc.close();
	}

}
