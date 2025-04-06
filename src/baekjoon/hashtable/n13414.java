package baekjoon.hashtable;

import java.io.*;
import java.util.*;

public class n13414 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// queue로 하면 contains할 때 순차적 탐색이라 O(N)
		// HashMap(Set)으로 하면 contains할 때 O(1)
		// input 받음(입력 순서대로 기록해야함. + 이미 contains면 순서 뒤로 바꿔야 함)
		// 순서대로 기록/뒤로 보내기 -> Queue -> But, contains할 때 O(N^2)
		// contains 여부 -> Map 두 개 쓰기
		HashMap<String, Integer> strMap = new HashMap<>();
		TreeMap<Integer, String> orderMap = new TreeMap<>(); // 마지막 출력을 빠르게 하기 위해서
		int order = 1;
		while(L-->0) { // O(L log L)
			String schoolNum = br.readLine();
			if(strMap.isEmpty() || !strMap.containsKey(schoolNum)) {
				strMap.put(schoolNum, order);
				orderMap.put(order++, schoolNum); // O(log L)
			}else { // strMap.containsKey(schoolNum))일 때
				// orderMap에서 order을 뒤로 바꿔야 함 O(log L)
				int preOrder = strMap.get(schoolNum); // 원래 order 찾기
				strMap.remove(schoolNum);
				orderMap.remove(preOrder);
				orderMap.put(order++, schoolNum);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(K-->0) { // O(K)
			sb.append(orderMap.pollFirstEntry().getValue()+"\n");
		}
		System.out.print(sb);
	}

}
