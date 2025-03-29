package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n10866 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int X;
			switch(cmd) {
				case "push_front":
					X = Integer.parseInt(st.nextToken());
					deque.addFirst(X);
					break;
				case "push_back":
					X = Integer.parseInt(st.nextToken());
					deque.addLast(X);
					break;
				case "pop_front":
					if(deque.isEmpty()) sb.append(-1+"\n");
					else sb.append(deque.pollFirst()+"\n");
					break;
				case "pop_back":
					if(deque.isEmpty()) sb.append(-1+"\n");
					else sb.append(deque.pollLast()+"\n");
					break;
				case "size":
					sb.append(deque.size()+"\n");
					break;
				case "empty":
					if(deque.isEmpty()) sb.append(1+"\n");
					else sb.append(0+"\n");
					break;
				case "front":
					if(deque.isEmpty()) sb.append(-1+"\n");
					else sb.append(deque.peekFirst()+"\n");
					break;
				case "back":
					if(deque.isEmpty()) sb.append(-1+"\n");
					else sb.append(deque.peekLast()+"\n");
			}
		}
		System.out.print(sb);
	}

}
