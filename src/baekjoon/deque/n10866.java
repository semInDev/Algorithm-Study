package baekjoon.deque;
import java.util.*;
import java.io.*;

public class n10866 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String input = br.readLine();
			if(input.equals("pop_front")) {
				if(deque.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(deque.pollFirst()+"\n");
				}
			}
			else if(input.equals("pop_back")) {
				if(deque.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(deque.pollLast()+"\n");
				}
			}
			else if(input.equals("size")) {
				sb.append(deque.size()+"\n");
			}
			else if(input.equals("empty")) {
				if(deque.isEmpty()) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
			}
			else if(input.equals("front")) {
				if(deque.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(deque.peekFirst()+"\n");
				}
			}
			else if(input.equals("back")) {
				if(deque.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(deque.peekLast()+"\n");
				}
			}
			else {//push_front X, push_back X 둘 중 하나
				StringTokenizer st = new StringTokenizer(input);
				if(st.nextToken().equals("push_front")) {
					int num = Integer.parseInt(st.nextToken());
					deque.addFirst(num);
				}else {//push_back
					int num = Integer.parseInt(st.nextToken());
					deque.addLast(num);
				}
			}
		}
		System.out.println(sb);
		br.close();
	}

}
