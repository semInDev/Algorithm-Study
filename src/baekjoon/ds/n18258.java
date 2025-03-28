package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n18258 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		StringTokenizer st;
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("push")) {
				int newItem = Integer.parseInt(st.nextToken());
				deque.add(newItem);
			}
			else if(cmd.equals("pop")) {
				if(deque.isEmpty()) sb.append(-1+"\n");
				else sb.append(deque.poll()+"\n");
			}
			else if(cmd.equals("size")) {
				sb.append(deque.size()+"\n");
			}
			else if(cmd.equals("empty")) {
				if(deque.isEmpty()) sb.append(1+"\n");
				else sb.append(0+"\n");
			}
			else if(cmd.equals("front")) {
				if(deque.isEmpty()) sb.append(-1+"\n");
				else sb.append(deque.peekFirst()+"\n");
			}
			else {//back
				if(deque.isEmpty()) sb.append(-1+"\n");
				else sb.append(deque.peekLast()+"\n");
			}
		}
		
		System.out.println(sb);
		
	}

}
