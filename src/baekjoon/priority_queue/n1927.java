package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

public class n1927 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> priority = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(priority.isEmpty()) {
					sb.append(0+"\n");
				}else {
					sb.append(priority.poll()+"\n");
				}
			}
			else {
				priority.add(x);
			}
		}
		System.out.print(sb);
	}

}
