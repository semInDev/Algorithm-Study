package baekjoon.hashtable;

import java.io.*;
import java.util.*;

/*남아있는 사람 사전 역순으로 출력
(남은 사람들을 TreeSet에 새로 넣을까? 아니면 애초에 HashSet말고 TreeSet에 넣을까?)
전자가 시간 복잡도 빠르지만 메모리가 더 들고, 후자가 메모리 적어도 상대적으로 느릴 듯*/
public class n7785 {
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 로그 수만큼 로직 반복 (HashSet 이용(출근 중복이어도 괜찮음, 퇴근 중복만 예외처리 해둘 것))
		// 이름 출/퇴근
		// 출 -> push(이름)
		// 퇴 -> remove(이름)
		TreeSet<String> set = new TreeSet<>(Collections.reverseOrder()); // 사전 역순 = 내림차순
		while(n-->0) { // O(n log n): RedBlackTree 삭입삭제 log n
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String cmd = st.nextToken();
			if(cmd.equals("enter")) {
				set.add(name);
			}
			else if(!set.isEmpty()) {
				set.remove(name);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!set.isEmpty()) {
			sb.append(set.pollFirst()+"\n");
		}
		System.out.print(sb);
	}
}
