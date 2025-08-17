package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n1926_re {
	static int n, m;
	static int cnt=0, maxExtent=0;
	static int[][] graph;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));		
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(graph[i][j] == 1) {
        			bfs(i, j);
        		}
        	}
        }
                
        System.out.println(cnt);
        System.out.println(maxExtent);        
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		
		// start
		queue.add(new int[] {x,y});
		graph[x][y] = 0;
		int extent = 1;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(0<=nx && nx<n && 0<=ny && ny<m && graph[nx][ny] == 1) {
					graph[nx][ny] = 0;
					extent++;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		cnt++;
		maxExtent = Math.max(maxExtent, extent);
	}

}
