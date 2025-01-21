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
		
		
		/*<자바의 정석> 익명클래스, 람다식, 함수형인터페이스
		 * 람다식은 익명함수가 아니라 익명객체이다!->2회성
		 * */
		
		/*
		//1. 익명 클래스
		Object obj = new Object() {
			int max(int a, int b) {
				return a>b ? a : b;
			}
		};
		
		int value = obj.max(3,5); //에러 
		*/
		
		//2. 함수형 인터페이스 + 익명 객체 생성
		MyFunction f1 = new MyFunction() {
			//int max(int a, int b) {//오버라이딩 규칙: 접근지정자를 좁게 바꿀 수 없음
			public int max(int a, int b) {
				return a>b ? a : b;
			} 
		};
		
		//3. 함수형 인터페이스 + 람다식(익명 객체 생성): 훨씬 더 간결해짐
		// 람다식(익명 객체)을 다루기 위한
		// 참조변수의 타입은 함수형 인터페이스를 기반으로 한다.
		int value = f1.max(3, 5);
		System.out.println(value);
		
		MyFunction f2 = (a, b) -> a > b ? a : b;
		System.out.println(f2.max(3, 5));
		
		//4. 활용 예시
		//람다 사용X
		List<String> list1 = Arrays.asList("abc","aaa","bbb","ddd","aaa");
		Collections.sort(list1, new Comparator<String>(){
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println(list1.toString());
		
		//람다 사용O
		List<String> list2 = Arrays.asList("abc","aaa","bbb","ddd","aaa");
		Collections.sort(list2, (o1, o2)->o1.compareTo(o2));
		System.out.println(list2.toString());
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

@FunctionalInterface//함수형 인터페이스라는 뜻이면서 아래의 인터페이스가 단 하나의 추상메서드만 갖는지 체크해줌
interface MyFunction{
	public abstract int max(int a, int b);
}