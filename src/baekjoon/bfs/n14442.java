package baekjoon.bfs;
import java.util.*;
import java.io.*;

public class n14442 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] end = {N-1, M-1};
		char[][] graph = new char[N][M];//0,0부터 시작 -> N-1, M-1까지 감
		for(int i=0; i<N; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		
		int[][][] dis = new int[N][M][K+1];//broken된 벽의 수
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				Arrays.fill(dis[i][j], -1);
			}
		}
		
		dis[0][0][0] = 1;//시작은 항상 벽이 없으니까 broken = 0일 때만 초기화해줌
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0,0});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0], y = cur[1], broken = cur[2];
			if(cur[0] == end[0] && cur[1] == end[1]) {
				System.out.println(dis[x][y][broken]);
				return;
			}
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0<=nx && nx<N && 0<=ny && ny<M) {
					//nxt에 여기 벽이 있는지 vs 없는지
					if(graph[nx][ny]=='0'&& dis[nx][ny][broken]==-1) {
						dis[nx][ny][broken] = dis[x][y][broken] + 1;
						queue.add(new int[] {nx, ny, broken});
					}
					else if(graph[nx][ny]=='1'&& broken<K && dis[nx][ny][broken+1]==-1) {
						dis[nx][ny][broken+1] = dis[x][y][broken] + 1;
						queue.add(new int[] {nx, ny, broken+1});
					}
				}
			}
		}
		System.out.println(-1);
	}

}
