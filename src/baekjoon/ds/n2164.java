package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n2164 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<N+1; i++) {
			queue.add(i);
		}
		
		while(queue.size() != 1) {
			queue.poll();
			
			int temp = queue.poll();
			queue.add(temp);
		}
		
		System.out.println(queue.poll());
	}

}
