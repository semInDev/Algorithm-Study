package baekjoon.bfs;
import java.util.*;
import java.io.*;

public class n2206 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][][] graph = new int[N][M][2];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				Arrays.fill(graph[i][j], -1);
			}
		}
		
		char[][] board = new char[N][M];
		for(int i=0; i<N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		Queue<int[]> queue = new ArrayDeque<>();
		graph[0][0][0] = graph[0][0][1] = 1;//시작점 초기화
		queue.add(new int[] {0,0,0});
		queue.add(new int[] {0,0,1});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1], broken = cur[2];
			if(x == N-1 && y == M-1) {
				System.out.println(graph[x][y][broken]);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					//1. "벽이 없을 때" && 아직 업데이트 안 한 상태
					//-> 지금까지 broken의 여부와 상관 없이 기존 broken을 유지하면 됨
					if(board[nx][ny]=='0' && graph[nx][ny][broken]==-1) {
						graph[nx][ny][broken] = graph[x][y][broken] + 1;
						queue.add(new int[] {nx, ny, broken});
					}
					//2. "벽이 있을 때" && 지금까지 broken X 인 상태 && 아직 업데이트 안 한 상태
					else if(board[nx][ny]=='1' && broken == 0 && graph[nx][ny][broken]==-1) {
						graph[nx][ny][1] = graph[x][y][broken] + 1;
						queue.add(new int[] {nx, ny, 1});
					}
				}
			}
		}
		System.out.println(-1);
	}

}
