package baekjoon.bfs;
import java.util.*;
import java.io.*;
/*[250122]
 * 예외케이스에 대해서 생각해보기
 * */

public class n4179 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] graph = new char[R][C];
		int[][] jGraph = new int[R][C];
		int[][] fGraph = new int[R][C];
		for(int i=0; i<R; i++) {
			Arrays.fill(jGraph[i], -1);
			Arrays.fill(fGraph[i], -1);
		}
		
		Queue<int[]> qf = new ArrayDeque<>();
		Queue<int[]> qj = new ArrayDeque<>();
		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				char c = input.charAt(j);
				graph[i][j] = c;
				if(c == 'J') {
					qj.add(new int[]{i, j});
					jGraph[i][j] = 0;
				}
				else if(c == 'F') {
					qf.add(new int[]{i, j});
					fGraph[i][j] = 0;
				}
			}
		}
		
		while(!qf.isEmpty()) {
			int[] cur = qf.poll();
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(0<=nx && nx<R && 0<=ny && ny<C
						&& graph[nx][ny] != '#'
						&& fGraph[nx][ny] == -1) {
					fGraph[nx][ny] = fGraph[cur[0]][cur[1]] + 1;
					qf.add(new int[] {nx, ny});
				}
			}
		}
		
		while(!qj.isEmpty()) {
			int[] cur = qj.poll();
			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx<0 || nx>=R || ny<0 || ny>=C) {
					System.out.println(jGraph[cur[0]][cur[1]] + 1);
					return;
				}
				else if(graph[nx][ny] != '#'&& jGraph[nx][ny] == -1) {
					if(jGraph[cur[0]][cur[1]] + 1 < fGraph[nx][ny]) {
						jGraph[nx][ny] = jGraph[cur[0]][cur[1]] + 1;
						qj.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}

}
