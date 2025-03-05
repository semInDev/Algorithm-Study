package icoda.greedy;
import java.util.*;

public class ch3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int output = 0;
		output += M/(K+1)*(arr[N-1]*K+arr[N-2]);
		output += M%(K+1)*(arr[N-1]*K);
		System.out.println(output);
		
		sc.close();
	}

}
