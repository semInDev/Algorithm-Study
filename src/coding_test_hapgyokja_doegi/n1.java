package coding_test_hapgyokja_doegi;
import java.util.*;

public class n1 {
	private static void solution(int[] arr) {
		//원본 비파괴적 방식: clone(copyOf) 이용
		int[] clone_arr = Arrays.copyOf(arr, arr.length);
		//int[] clone_arr = arr.clone();
		Arrays.sort(clone_arr);
		System.out.println(Arrays.toString(clone_arr));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1,-5,2,4,3};
		int[] arr2 = {2,1,1,3,2,5,4};
		int[] arr3 = {6,1,7};
		
		solution(arr1);
		solution(arr2);
		solution(arr3);
	}

}
