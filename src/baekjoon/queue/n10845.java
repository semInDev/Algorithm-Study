package baekjoon.queue;
import java.util.*;
import java.io.*;

public class n10845 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			String input = br.readLine();
			if(input.equals("pop")) {
				if(queue.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(queue.poll()+"\n");
				}
			}
			else if(input.equals("size")) {
				sb.append(queue.size()+"\n");
			}
			else if(input.equals("empty")) {
				if(queue.isEmpty()) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}			
			}
			else if(input.equals("front")) {
				if(queue.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(queue.peekFirst()+"\n");
				}			
			}
			else if(input.equals("back")) {
				if(queue.isEmpty()) {
					sb.append(-1+"\n");
				}else {
					sb.append(queue.peekLast()+"\n");
				}			
			}
			else {//push X
				StringTokenizer st = new StringTokenizer(input);
				st.nextToken();//push 버리기
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
			}
		}
		System.out.print(sb);
		br.close();
	}

}
