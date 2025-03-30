package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n2346 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N+1]; // 'x번 풍선의 종이에 적힌 수 y'에서 x(index)에 해당하는 y를 저장할 배열
		ArrayDeque<Integer> deque = new ArrayDeque<>(); // 'x번 풍선'에서 x를 저장할 덱
		for(int i=1; i<N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			deque.addLast(i);
		}
		
		while(deque.size()!=1) {
			int cur = deque.pollFirst();
			sb.append(cur+" ");
			
			int nxt = arr[cur];
			
			if(nxt>0) {
				for(int i=0; i<nxt-1; i++) {
					deque.addLast(deque.pollFirst());
				}
			}else {
				nxt = (-1) * nxt;
				for(int i=0; i<nxt; i++) {
					deque.addFirst(deque.pollLast());
				}
			}
		}
		sb.append(deque.pollFirst());
		System.out.println(sb);
	}
}
/* Solution Description

- java 컬렉션 프레임워크의 ArrayDeque를 사용한다.
원형으로 배치된 풍선들에 대해 focus를 앞/뒤로 이동시키는 것을 덱을 통해 구현할 수 있다.

*/