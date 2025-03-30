package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n1966 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int prioritys[] = new int[N+1];
			st = new StringTokenizer(br.readLine());
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			for(int i=1; i<N+1; i++) {
				prioritys[i] = Integer.parseInt(st.nextToken());
				deque.addLast(i);
			}
			
			int orders[] = new int[N+1]; // 몇번째에 인쇄되었는지 기록하는 배열 
			int order = 1;
			while(orders[M+1]==0) { // 시간 개선
				// 1. 가장 우선 순위가 높은 인덱스 찾기
				int maxIndex = deque.peekFirst(); // deque에 남아있는 인덱스 중 가장 우선순위가 높은 인덱스
				deque.addLast(deque.pollFirst());
				for(int i=1; i<deque.size(); i++) {
					if(prioritys[maxIndex] < prioritys[deque.peekFirst()]) {
						maxIndex = deque.peekFirst();
					}
					deque.addLast(deque.pollFirst());
				}
				
				// 2. 가장 우선 순위가 높은 인덱스만큼 덱 이동하기
				while(deque.peekFirst() != maxIndex) {
					deque.addLast(deque.pollFirst());
				}
				orders[deque.pollFirst()] = order++;
			}
			sb.append(orders[M+1]+"\n");
		}
		System.out.print(sb);
	}

}
/* Solution Description

- java 컬렉션 프레임워크의 ArrayDeque를 사용한다.

1. 가장 큰 우선순위를 갖는 인덱스를 for문을 돌며 구한다. O(N^2)이지만, N<=100이므로 가능하다.

2. 가장 큰 우선순위를 갖는 인덱스까지 앞에 원소들을 차례로 뒤로 보내기 위해서 덱을 사용한다.

3. (시간 개선 방식) while(orders[M+1]==0)을 사용하여 목표인 M+1의 프린트 순서를 알게 된 순간 로직을 종료한다.

*/