package baekjoon.recursive;

import java.io.*;
import java.util.*;

public class n2630 {
	static int cnt0 = 0;
	static int cnt1 = 0;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		partitioning(0,0,N);
		System.out.println(cnt0);
		System.out.println(cnt1);
	}
	
	private static void partitioning(int x, int y, int size) {
		// size == 1 || sameAll_true -> cnt 올리기
		if(size == 1 || sameAll(x,y,size)) {
			if(graph[x][y] == 0) cnt0++;
			else cnt1++;
			return;
		}
		// sameAll_false -> partitioning 4등분
		int newSize = size/2;
		partitioning(x,y,newSize);
		partitioning(x,y+newSize,newSize);
		partitioning(x+newSize,y,newSize);
		partitioning(x+newSize,y+newSize,newSize);
	}
	private static boolean sameAll(int x, int y, int size) {
		int start = graph[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(start != graph[i][j]) return false;
			}
		}
		return true;
	}

}
