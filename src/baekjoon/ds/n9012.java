package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n9012 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Stack<Character> stack;
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			boolean tf = true; 
			String input = br.readLine();
			stack = new Stack<>();
			for(int i=0; i<input.length(); i++) {
				char c = input.charAt(i);
				if(c == '(') stack.push('(');
				else {// )
					if(stack.isEmpty()) {
						sb.append("NO\n");
						tf = false;
						break;
					}
					else stack.pop();
				}
			}
			if(tf) {//이거 없으면 stack empty일 때 pop하면 NO받을 때 NO\nYES\n라고 에러남
				if(stack.isEmpty()) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		
		System.out.print(sb);
	}
}
