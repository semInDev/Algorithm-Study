package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 꼭 문자열로 만들 필요는 없다. 배열에 저장해놓고 마지막에 합쳐도 된다.
public class n2447 {
	static int N; 
	static String[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		graph = new String[N][N];
		partitioning(0,0,N);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(graph[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	// y == N-1이면 줄바꿈 해줘야 함
	private static void partitioning(int x, int y, int size) {
		if(size == 1) {
			graph[x][y] = "*";
			return;
		}
		
		int newSize = size/3;
		partitioning(x,y,newSize);
		partitioning(x,y+newSize,newSize);
		partitioning(x,y+newSize*2,newSize);
		
		partitioning(x+newSize,y,newSize);
		//partitioning(x+newSize,y+newSize,newSize,true);
		for(int i=x+newSize; i<x+newSize*2; i++) {
			for(int j=y+newSize; j<y+newSize*2; j++) {
				graph[i][j] = " ";
			}
		}
		partitioning(x+newSize,y+newSize*2,newSize);
		
		partitioning(x+newSize*2,y,newSize);
		partitioning(x+newSize*2,y+newSize,newSize);
		partitioning(x+newSize*2,y+newSize*2,newSize);
	
	}
}
