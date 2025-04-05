package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

public class n11286 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			if(abs1 == abs2) return o1 > o2 ? 1 : -1;
			return abs1 - abs2; // return abs1 > abs2 ? 1 : -1;
		});
		
		StringBuilder sb = new StringBuilder();
		while(N-->0) {
			int x = Integer.parseInt(br.readLine());
			
			// 1. x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산
			if(x != 0) {
				pq.add(x);
			}
			else {
				// 2.  만약 배열이 비어 있는 경우인데
				// 절댓값이 가장 작은 값을 출력하라고 한 경우 0을 출력하면 된다.
				if(pq.isEmpty()) sb.append("0\n");
				// 3. x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고
				// 그 값을 배열에서 제거하는 경우
				else {
					sb.append(pq.poll()+"\n");
				}
			}
		}
		System.out.print(sb);
		
	}

}
