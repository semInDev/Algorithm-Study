package coding_test_hapgyokja_doegi;
import java.util.*;

public class n3 {
	private static void solution(int[] arr) {
		Set<Integer> set = new TreeSet<>();
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				set.add(arr[i]+arr[j]);
			}
		}
		System.out.println(Arrays.toString(set.toArray()));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {2,1,3,4,1};
		int[] arr2 = {5,0,2,7};
		
		solution(arr1);
		solution(arr2);
	}

}
