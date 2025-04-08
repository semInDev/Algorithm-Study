package baekjoon.recursive;

import java.io.*;
import java.util.*;

public class n1780 {
	static int cnt1 = 0; // -1
	static int cnt2 = 0; // 0
	static int cnt3 = 0; // 1
	static int[][] graph;
	public static void main(String[] args)throws IOException {
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
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}
	private static void partitioning(int x, int y, int size) {
		//sameAll 체크
		if(sameAll(x,y,size) || size == 1) {
			if(graph[x][y] == -1) cnt1++;
			else if(graph[x][y] == 0) cnt2++;
			else cnt3++;
			
			return;
		}
		
		// partitioning
		int newSize = size/3;
		partitioning(x, y, newSize);
		partitioning(x, y+newSize, newSize);
		partitioning(x, y+newSize*2, newSize);
		
		partitioning(x+newSize, y, newSize);
		partitioning(x+newSize, y+newSize, newSize);
		partitioning(x+newSize, y+newSize*2, newSize);
		
		partitioning(x+newSize*2, y, newSize);
		partitioning(x+newSize*2, y+newSize, newSize);
		partitioning(x+newSize*2, y+newSize*2, newSize);
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
/*
 * 글로벌 변수: count1,2,3 변수
 * tf확인하는 함수 만들기(시작 좌표/총 size 넣고, tf 빼고)
 * -> [재귀]파티셔닝해주는 함수 만들기(tf확인 후 t or size하나면 그냥 return하기
 * /f면 9등분하기
 * 00(size*0) 03(size*1/3) 06(size*2/3)
 * 30 33 36
 * 60 63 66
 * */
