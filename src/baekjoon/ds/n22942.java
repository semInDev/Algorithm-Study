package baekjoon.ds;

import java.io.*;
import java.util.*;

public class n22942 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 1. 양쪽 좌표와 괄호 TreeMap에 저장 -> containsKey 확인
		TreeMap<Integer, int[]> map = new TreeMap<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			if(map.containsKey(x-r) || map.containsKey(x+r)) { // 접할 때
				while(++i<N) {
					br.readLine(); // 나머지 input 버리기
				}
				System.out.println("NO");
				return;
			}
			map.put(x-r, new int[]{0, x}); // 0 = '('
			map.put(x+r, new int[]{1, x}); // 1 = ')'
		}
		
		// 2. values[괄호, center]로 stack에 하나씩 넣기 -> center가 같으면 pop 가능
		// 짝이 안 맞거나 center가 다르면 No
		ArrayDeque<int[]> stack = new ArrayDeque<>(); 
		List<int[]> list = new ArrayList<>(map.values());
		for(int[] v : list){
			if(v[0] == 0) { // ( 일 때
				stack.addLast(v);
			}else { // ) 일 때
				if(stack.peekLast()[1] != v[1]) { // 원의 중심 좌표가 다르다면 -> No
					System.out.println("NO");
					return;
				}
				stack.pollLast();
			}
		}
		System.out.println("YES");
	}

}
