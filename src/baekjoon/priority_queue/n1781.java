package baekjoon.priority_queue;

import java.io.*;
import java.util.*;

/*
 * '예제에서 알려주지 않는 테스트 케이스'를 찾아야 하는 문제
 * (1,6)(1,7)(2,9)(2,10)일 때 에러 발생
 * => temp pq를 하나 만들어서 다음 time의 라면수도 비교해보면 좋을 것 같음
 * */
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
			int ramen = Integer.parseInt(st.nextToken());
			pq.add(new int[] {deadLine, ramen});
		}
		
		PriorityQueue<Integer> solve = new PriorityQueue<>(); // 푼 문제의 컵라면 수
		int time = 0; // 시간 = 푼 문제 수 -개선-> 별도의 time변수없이 solve.size()이 곧 시간임
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(time < cur[0]) {
				solve.add(cur[1]);
				time++;
			}else {
				if(cur[1]>solve.peek()) {
					solve.poll();
					solve.add(cur[1]);
				}
			}
		}
		int result = 0;
		while(!solve.isEmpty()) {
			result += solve.poll();
		}
		System.out.println(result);
	}

}
