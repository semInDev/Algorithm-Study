package baekjoon.recursion;

import java.io.*;

public class n1992 {
	static int[][] graph;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}
		partitioning(0,0,N);
		System.out.println(sb);
	}
	
	private static void partitioning(int x, int y, int size) {
		if(size == 1 || sameAll(x,y,size)) {
			sb.append(graph[x][y]);
			return;
		}
		
		int newSize = size/2;
		sb.append("(");
		partitioning(x,y,newSize);
		partitioning(x,y+newSize,newSize);
		partitioning(x+newSize,y,newSize);
		partitioning(x+newSize,y+newSize,newSize);
		sb.append(")");
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
