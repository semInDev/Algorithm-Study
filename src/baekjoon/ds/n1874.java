package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n1874 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int num = 1;
		while(N-->0) {
			int cur = Integer.parseInt(br.readLine());
			if(stack.isEmpty() || stack.peekLast()<=cur) {
				while(stack.isEmpty() || stack.peekLast() != cur) {
					stack.addLast(num++);
					sb.append("+\n");
				}
				stack.pollLast();
				sb.append("-\n");
			}
			else { // stack.peekLast() > cur
				while(N-->0) { // 남은 입력 받기
					br.readLine();
				}
				System.out.println("NO");
				return;
			}
		}
		System.out.print(sb);
	}

}
