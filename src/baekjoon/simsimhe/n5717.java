package baekjoon.simsimhe;

import java.io.*;
import java.util.*;
public class n5717 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int F = Integer.parseInt(st.nextToken());
		while(!(M==0 && F==0)) {
			sb.append(M+F).append("\n");
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			F = Integer.parseInt(st.nextToken());
		}
		System.out.print(sb);
		
	}

}
