package baekjoon.deque;
import java.util.*;
import java.io.*;

public class n1021 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		while(N>0) {
			deque.addFirst(N--);
		}
		
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		while(M-->0) {
			int target = Integer.parseInt(st.nextToken());
			int target_idx=1;
			for(Integer num : deque) {
				if(num == target) {
					break;
				}
				target_idx++;
			}

			if(target_idx <= deque.size()/2 + 1) {//왼쪽으로 이동
				for(int i=0; i<target_idx-1; i++) {
					ans++;
					int temp = deque.pollFirst();
					deque.addLast(temp);
				}
			}else {//오른쪽으로 이동
				for(int i=target_idx; i<deque.size()+1; i++) {
					ans++;
					int temp = deque.pollLast();
					deque.addFirst(temp);
				}
			}
			deque.pollFirst();
		}
		System.out.println(ans);
	}

}
