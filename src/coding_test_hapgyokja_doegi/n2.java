package coding_test_hapgyokja_doegi;
import java.util.*;

public class n2 {
	private static void solution(int[] arr) {
		//중복값 제거 - Set
		//내림차순 정렬 - TreeSet
		Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
		//Set<Integer> set = new TreeSet<>();//이건 내림차순
		for(int num : arr) {
			set.add(num);
		}
		System.out.println(Arrays.toString(set.toArray()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {4,2,2,1,3,4};
		int[] arr2 = {2,1,1,3,2,5,4};
		
		solution(arr1);
		solution(arr2);
	}

}
