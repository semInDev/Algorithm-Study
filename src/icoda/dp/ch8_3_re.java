package icoda.dp;
import java.util.*;

public class ch8_3_re {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] output = new int[n];
		output[0] = arr[0];
		output[1] = arr[1];
		for(int i=2; i<n; i++) {
			output[i] = Math.max(output[i-1], output[i-2]+arr[i]);
		}
		
		System.out.println(output[n-1]);
		sc.close();
	}

}
