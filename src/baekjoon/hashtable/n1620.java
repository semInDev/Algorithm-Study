package baekjoon.hashtable;

import java.io.*;
import java.util.*;

public class n1620 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> intMap = new HashMap<>();
		HashMap<String, Integer> strMap = new HashMap<>();
		for(int i=1; i<N+1; i++) {
			String name = br.readLine();
			intMap.put(i, name);
			strMap.put(name, i);
		}
		StringBuilder sb = new StringBuilder();
		while(M-->0) {
			String cmd = br.readLine();
			if(strMap.containsKey(cmd)) {
				sb.append(strMap.get(cmd)+"\n");
			}else {
				sb.append(intMap.get(Integer.parseInt(cmd))+"\n");
			}
		}
		System.out.print(sb);
	}

}
