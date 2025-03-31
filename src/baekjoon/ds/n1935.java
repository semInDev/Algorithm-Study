package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n1935 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String exp = br.readLine();
		
		int nums[] = new int[N]; // 'A'을 0이라고 둠.
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		// 단일 스레드 환경인 PS에서는 Stack보다 ArrayDeque가 더 효율적임
		ArrayDeque<Double> stack = new ArrayDeque<>();
		for(int i=0; i<exp.length(); i++) {
			char cur = exp.charAt(i);
			if(cur == '+' || cur == '-' || cur == '*' || cur == '/') {
				double a = stack.pollLast();
				double b = stack.pollLast();
				switch(cur) {
				case '+':
					stack.addLast(b+a);
					break;
				case '-':
					stack.addLast(b-a);
					break;
				case '*':
					stack.addLast(b*a);
					break;
				case '/':
					stack.addLast(b/a);
				}
			}
			else { // 알파벳일 때
				double newNum = nums[cur - 'A']; // stack의 Double 형식에 맞추기 위해 newNum을 double로 받음
				stack.addLast(newNum);
			}
		}
		System.out.printf("%.2f", stack.pollLast());
	}
}
/* Solution Description

- Stack을 사용하면 되는 문제지만
	 java의 경우, 단일 스레드 환경인 PS에서는 Stack보다 ArrayDeque가 더 효율적임
	 - https://seminrevolution.tistory.com/11 참고
	 따라서 java 컬렉션 프레임워크의 ArrayDeque을 Stack처럼 사용한다.

*/