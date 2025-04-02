package baekjoon.stack;

import java.io.*;
import java.util.*;

public class n2493 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i=1; i<N+1; i++) {
			int cur = arr[i];
			while(!stack.isEmpty() && arr[stack.peekLast()] < cur) {
				stack.pollLast();
			}
			if(stack.isEmpty()) {
				sb.append(0+" ");
			}
			else {
				sb.append(stack.peekLast()+" ");
			}
			stack.addLast(i);
		}
		
		System.out.println(sb);
	}

}
