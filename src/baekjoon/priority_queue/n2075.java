package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

// 시간복잡도: O(n log n)
public class n2075 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=0; i<N-1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}

}
