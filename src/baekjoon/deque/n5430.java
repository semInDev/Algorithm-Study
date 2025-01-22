package baekjoon.deque;
import java.util.*;
import java.io.*;

public class n5430 {
	/*
	 * 뒤집기를 구현하는 과정에서의 시간복잡도에 신경썼다.
	 * 스택(덱도 가능)을 이용한 뒤집기 방법을 생각하고,
	 * 뒤집기에 대한 시간복잡도를 단순히 O(2N)이라고만 생각했다.
	 * 하지만 뒤집기 명령을 N번만큼 할 수 있기에
	 * O(N^2)이 될 수 있었다. 
	 * */
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test = Integer.parseInt(br.readLine());
		while(test-->0) {
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			
			String cmds = br.readLine();
			int arrLength = Integer.parseInt(br.readLine());
			String inputArr = br.readLine();
			for(int i=0; i<arrLength; i++) {
				int num = Integer.parseInt(inputArr.charAt(2*i+1)+"");
				deque.addLast(num);
			}
			
			boolean error = false;
			for(int i=0; i<cmds.length(); i++) {
				char cmd = cmds.charAt(i);
				if(cmd == 'R') {
					ArrayDeque<Integer> newDeque = new ArrayDeque<>();
					while(!deque.isEmpty()) {
						int temp = deque.pollLast();
						newDeque.addLast(temp);
					}
					deque.addAll(newDeque);
				}else {//'D'
					if(deque.isEmpty()) {
						error = true;
						break;
					}else {
						deque.pollFirst();
					}
				}
			}
			
			if(error) {
				sb.append("error\n");
			}else {
				sb.append("[");
				for(int num : deque) {
					sb.append(num+",");
				}
				sb.delete(sb.length()-1, sb.length());//쉼표 하나 삭제
				sb.append("]\n");
			}
			
		}
		System.out.print(sb);
		br.close();
		
	}

}
