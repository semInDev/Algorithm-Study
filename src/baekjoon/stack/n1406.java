package baekjoon.stack;

import java.io.*;
import java.util.*;

// 시간복잡도: O(500,000)
public class n1406 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int M = Integer.parseInt(br.readLine());
		
		ArrayDeque<Character> left = new ArrayDeque<>();
		ArrayDeque<Character> right = new ArrayDeque<>();
		for(int i=0; i<str.length(); i++) {
			left.addLast(str.charAt(i));
		}
		
		while(M-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			switch(cmd){
				case "L":
					if(!left.isEmpty()) right.addLast(left.pollLast());
					break;
				case "D":
					if(!right.isEmpty()) left.addLast(right.pollLast());
					break;
				case "B":
					if(!left.isEmpty()) left.pollLast();
					break;
				case "P":
					char newChar = st.nextToken().charAt(0); // charAt(0)은 char로 캐스팅하려고
					left.addLast(newChar);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!left.isEmpty()) {
			sb.append(left.pollFirst());
		}
		while(!right.isEmpty()) {
			sb.append(right.pollLast());
		}
		System.out.println(sb);
	}

}
