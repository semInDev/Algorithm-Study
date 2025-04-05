package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

public class n1781 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			if(o1[0] == o2[0]) {
				return o2[1] - o1[1]; //컵라면 기준 maxHeap(내림차순)
			}
			return o1[0] - o2[0]; // 데드라인 기준 minHeap(오름차순)
		});
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int deadLine = Integer.parseInt(st.nextToken());
			int gift = Integer.parseInt(st.nextToken());
			pq.add(new int[] {deadLine, gift});
		}
		
		int time = 0; // 시간 = 푼 문제 수
		int result = 0; // 최대로 받을 수 있는 컵라면 수 int범위
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(time < cur[0]) {
				result += cur[1];
				time++;
			}
		}
		System.out.println(result);
	}

}
