package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n10828 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st;
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				int newItem = Integer.parseInt(st.nextToken());
				stack.push(newItem);
			}
			else if(cmd.equals("pop")) {
				if(stack.isEmpty()) sb.append(-1+"\n");
				else sb.append(stack.pop()+"\n");
			}
			else if(cmd.equals("size")) {
				sb.append(stack.size()+"\n");
			}
			else if(cmd.equals("empty")) {
				if(stack.isEmpty()) sb.append(1+"\n");
				else sb.append(0+"\n");
			}
			else {//top
				if(stack.isEmpty()) sb.append(-1+"\n");
				else sb.append(stack.peek()+"\n");
			}
		}
		System.out.println(sb);
	}

}
