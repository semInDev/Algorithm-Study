package baekjoon.bst;
import java.util.*;
import java.io.*;

public class n21939 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>((o1,o2)->o2.compareTo(o1));
		HashMap<Integer, Integer> ptol = new HashMap<>();//P -> L 매핑
		//TreeSet<Integer> temp = new TreeSet<>((o1,o2)->o2.compareTo(o1));
		int N = Integer.parseInt(br.readLine());
		while(N-->0) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			if(!map.isEmpty() && map.containsKey(L)) {
				//map.put(L, map.get(L).add(P)); -> add의 리턴값은 boolean
				map.get(L).add(P);
			}else {//empty거나 없는 key라면
				TreeSet<Integer> newSet = new TreeSet<>((o1, o2) -> o2.compareTo(o1)); // TreeSet 생성
			    newSet.add(P);
			    map.put(L, newSet);
			}
			ptol.put(P,L);
		}
		int M = Integer.parseInt(br.readLine());
		while(M-->0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if(cmd.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				if(!map.isEmpty() && map.containsKey(L)) {
					map.get(L).add(P);
				}else {//empty거나 없는 key라면
					TreeSet<Integer> newSet = new TreeSet<>((o1, o2) -> o2.compareTo(o1)); // TreeSet 생성
				    newSet.add(P);
				    map.put(L, newSet);
				}
				ptol.put(P,L);
			}else if(cmd.equals("recommend")) {
				if(map.isEmpty())
					continue;
				int output;
				int cmd_num = Integer.parseInt(st.nextToken());
				if(cmd_num == 1) {
					int hard_L = map.firstKey();
					output = map.get(hard_L).first();
					/*
					if(map.get(hard_L).size()>1) {
						output = map.get(hard_L).first();
					}else {//map.get(hard_L).size()==1
						output = map.firstKey();
					}
					*/
				}else {//-1
					int easy_L = map.lastKey();
					output = map.get(easy_L).last();
					/*
					if(map.get(easy_L).size()>1) {
						output = map.get(easy_L).last();
					}else {//map.get(hard_L).size()==1
						output = map.lastKey();
					}
					*/
				}
				sb.append(output+"\n");
			}else {//solved
				if(map.isEmpty())
					continue;
				int P = Integer.parseInt(st.nextToken());
				int L = ptol.get(P);
				map.get(L).remove(P);
				if(map.get(L).size()==0)
					map.remove(L);
			}
		}
		System.out.print(sb);
	}
}
