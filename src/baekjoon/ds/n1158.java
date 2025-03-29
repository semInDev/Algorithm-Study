package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n1158 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<N+1; i++) {
			queue.add(i);
		}
		while(queue.size()!=1) {
			for(int i=0; i<K-1; i++) {
				int temp = queue.poll();
				queue.add(temp);
			}
			sb.append(queue.poll() + ", ");
		}
		sb.append(queue.poll()+">");
		System.out.println(sb);
	}

}
