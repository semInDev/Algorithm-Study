package baekjoon.bs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n1920_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));        
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			// Arrays.binarySearch는 key의 인덱스 리턴. 없으면 음수 숫자 리턴.
			if(Arrays.binarySearch(arr, num)>=0) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		
		System.out.print(sb);

	}
}
