package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

public class n11279 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()+"\n");
			}else {
				pq.add(x);
			}
		}
		System.out.print(sb);
	}

}

