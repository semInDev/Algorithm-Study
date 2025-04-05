package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

// 허프만과 같은 원리의 그리디: O(100,000)
// overflow check: Long타입 사용하기
public class n1715 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		// input 받기 + input 받은 것 정렬
		for(int i=0; i<N; i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		long result = 0;
		while(pq.size() != 1) {
			long temp = pq.poll() + pq.poll();
			result += temp;
			pq.add(temp);
		}
		System.out.println(result);
	}

}
