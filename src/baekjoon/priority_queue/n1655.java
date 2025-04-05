package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

// 시간복잡도: O(NlogN)
public class n1655 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 중간값 기준 왼쪽(maxHeap)
		PriorityQueue<Integer> right = new PriorityQueue<>(); // 중간값 기준 오른쪽(minHeap)
		StringBuilder sb = new StringBuilder();
		
		left.add(Integer.parseInt(br.readLine()));
		sb.append(left.peek()+"\n");
		for(int i=2; i<N+1; i++) {
			int newNum = Integer.parseInt(br.readLine());
			if(i%2 == 0) { // 짝수 번째
				if(left.peek() < newNum) {
					right.add(newNum);
				}else {
					right.add(left.poll());
					left.add(newNum);
				}
			}else {
				if(right.peek() > newNum) {
					left.add(newNum);
				}else {
					left.add(right.poll());
					right.add(newNum);
				}
			}
			sb.append(left.peek()+"\n");
		}
		System.out.print(sb);
	}

}
