package icoda.greedy;
import java.util.*;

//O(K): K = 동전의 개수(arr.length)
public class ch3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int output = 0;
		
		int[] arr = {500,100,50,10};
		for(int i=0; i<arr.length; i++) {
			output += N/arr[i];
			N %= arr[i];
		}
		
		System.out.println(output);
		sc.close();
	}

}
