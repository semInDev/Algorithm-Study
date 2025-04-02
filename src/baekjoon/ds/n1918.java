package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n1918 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			if(cur=='(') {
				stack.addLast(cur);
			}
			else if(cur == '*' || cur == '/') {
				while(!stack.isEmpty() && (stack.peekLast()=='*' || stack.peekLast()=='/')) {
					sb.append(stack.pollLast());
				}
				stack.addLast(cur);
			}
			else if(cur == '+' || cur == '-') {
				while(!stack.isEmpty() && stack.peekLast() != '(') {
					sb.append(stack.pollLast());
				}
				stack.addLast(cur);
			}
			else if(cur == ')') {
				while(stack.peekLast() != '(') {
					sb.append(stack.pollLast());
				}
				stack.pollLast(); // ( 버리기
			}
			else { // 알파벳
				sb.append(cur);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		System.out.println(sb);
	}

}
