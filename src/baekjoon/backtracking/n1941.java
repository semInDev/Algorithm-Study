package baekjoon.backtracking;

import java.io.*;

public class n1941 {
	static int cnt = 0;
	static char[][] graph = new char[5][5];
	static boolean[][] visited = new boolean[5][5];
	// static boolean[][] isCount = new boolean[5][5];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));		
		for(int i=0; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<5; j++) {
				graph[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				bt(0,0,i,j);
				visited[i][j] = true;
			}
		}
		
		System.out.println(cnt);
	}
	private static void bt(int depth, int S, int curX, int curY) {
		if(depth == 7) {
			if(S >= 4) cnt++;
			return;
		}
		for(int i=0; i<4; i++) {
			int nx = curX + dx[i];
			int ny = curY + dy[i];
			if(0<=nx && nx<5 && 0<=ny && ny<5
					&& !visited[nx][ny]) {
				visited[nx][ny] = true;
				if(graph[nx][ny] == 'S') S++;
				
				bt(depth+1, S, nx, ny);
				
				visited[nx][ny] = false;
				if(graph[nx][ny] == 'S') S--;
			}
		}
	}
}
