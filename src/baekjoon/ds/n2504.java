package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n2504 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int result = 0;
		int temp = 1;
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for(int i=0; i<str.length(); i++) {
			char cur = str.charAt(i);
			if(cur == '(') {
				temp *= 2;
				stack.addLast('(');
			}
			else if(cur == '[') {
				temp *= 3;
				stack.addLast('[');
			}
			else if(cur == ')') {
				if(stack.isEmpty() || stack.peekLast() != '(') {
					System.out.println(0);
					return;
				}
				else if(str.charAt(i-1) == '(') {
					result += temp;
				}
				temp /= 2;
				stack.pollLast();
			}
			else { // ]
				if(stack.isEmpty() || stack.peekLast() != '[') {
					System.out.println(0);
					return;
				}
				else if(str.charAt(i-1) == '[') {
					result += temp;
				}
				temp /= 3;
				stack.pollLast();
			}
		}
		if(!stack.isEmpty()) {
			System.out.println(0);
			return;
		}
		System.out.println(result);
	}

}
