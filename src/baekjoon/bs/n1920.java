package baekjoon.bs;

import java.io.*;
import java.util.*;

public class n1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));        
		int N = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(set.contains(num)) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		
		System.out.print(sb);

	}

}
