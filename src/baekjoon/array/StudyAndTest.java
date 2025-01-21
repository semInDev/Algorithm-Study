package baekjoon.array;
import java.util.*;

public class StudyAndTest {
	public static void main(String[] args) {
		/* <자바의 정석> ch11-31. Comparator와 Comparable
		 * #예제 11-7
		 * 주석 내용 자세히 정리: https://blog.naver.com/semin6634/223732558949
		 * */
		String[] strArr = {"cat", "Dog", "lion", "tiger"};
		
		Arrays.sort(strArr, new Descending());
		System.out.println(Arrays.toString(strArr));
		//Dog가 맨 뒤인 이유는 대문자가 소문자보다 순서가 앞서기때문(사전순)
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);//대소문자 구분을 없애줌
		System.out.println(Arrays.toString(strArr));
	}

}
class Descending implements Comparator{
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			//Comparable c2 = (Comparable)o2;
			return c1.compareTo(o2)*-1;
			//return c2.compareTo(o1);과 같은 결과가 나옴
		}
		//return -1
        throw new IllegalArgumentException("Arguments must implement Comparable");
	}
}