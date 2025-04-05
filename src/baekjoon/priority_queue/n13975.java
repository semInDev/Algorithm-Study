package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

// 허프만 그리디 알고리즘
public class n13975 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			long result = 0;
			while(pq.size() != 1) {
				long temp = pq.poll() + pq.poll();
				result += temp;
				pq.add(temp);
			}
			sb.append(result+"\n");
		}
		System.out.print(sb);
	}

}
