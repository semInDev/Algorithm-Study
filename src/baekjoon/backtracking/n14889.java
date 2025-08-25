package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n14889 {
	static int minDiff = Integer.MAX_VALUE;
	static int N;
	static int[][] graph;
	static boolean[] visited;
	// static int[] arr;

	public static void main(String[] args)throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));        
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        graph = new int[N][N];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        visited = new boolean[N]; // N+1?
        // arr = new int[N/2];
        
        // bt로 조합 찾기 -> 계산 후 minDiff 갱신
        visited[0] = true;
        backtracking(1, 0);
        
        System.out.println(minDiff);
	}
	
	private static void backtracking(int depth, int preIdx) {
		if(depth >= N/2) {
			// visited true끼리 조합 계산
			int sumTrue = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) {
					for(int j=i+1; j<N; j++) {
						if(visited[j]) sumTrue += (graph[i][j] + graph[j][i]);
					}
				}
			}
			// visited false끼리 조합 계산
			int sumFalse = 0;
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					for(int j=i+1; j<N; j++) {
						if(!visited[j]) sumFalse += (graph[i][j] + graph[j][i]);
					}
				}
			}
			// 차이값 갱신
			int diff;
			if(sumTrue - sumFalse < 0) diff = sumFalse - sumTrue;
			else diff = sumTrue - sumFalse;
			
			if(minDiff > diff) minDiff = diff;
			
			return;
		}
		for(int i=preIdx+1; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backtracking(depth+1, i);
				visited[i] = false;
			}
		}
	}

}
