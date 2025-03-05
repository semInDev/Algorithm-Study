package icoda.greedy;
import java.util.*;

//O(NlogN): N = arr.length, 정렬 시간
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
		int first = arr[N-1];
		int second = arr[N-2];
		
		int output = 0;
		output += M/(K+1)*(first*K+second);
		output += M%(K+1)*(first*K);
		System.out.println(output);
		
		sc.close();
	}

}
