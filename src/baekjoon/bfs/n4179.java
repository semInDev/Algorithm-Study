package baekjoon.bfs;
import java.util.*;
import java.io.*;
/*[250122]
 * 예외케이스에 대해서 생각해보기
 * */

public class n4179 {
    static int[][] dist1; // 불의 전파 시간
    static int[][] dist2; // 지훈이의 이동 시간
    static String[] board; // 미로
    static int n, m; // 미로의 크기
    static int[] dx = {1, 0, -1, 0}; // 이동 방향 (x축)
    static int[] dy = {0, 1, 0, -1}; // 이동 방향 (y축)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist1 = new int[n][m];
        dist2 = new int[n][m];
        board = new String[n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist1[i], -1);
            Arrays.fill(dist2[i], -1);
        }

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        Queue<int[]> Q1 = new LinkedList<>(); // 불의 전파를 위한 BFS 큐
        Queue<int[]> Q2 = new LinkedList<>(); // 지훈이의 이동을 위한 BFS 큐

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'F') {
                    Q1.add(new int[]{i, j});
                    dist1[i][j] = 0;
                }
                if (board[i].charAt(j) == 'J') {
                    Q2.add(new int[]{i, j});
                    dist2[i][j] = 0;
                }
            }
        }

        // 불의 전파 BFS
        while (!Q1.isEmpty()) {
            int[] cur = Q1.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (dist1[nx][ny] >= 0 || board[nx].charAt(ny) == '#') continue;
                dist1[nx][ny] = dist1[cur[0]][cur[1]] + 1;
                Q1.add(new int[]{nx, ny});
            }
        }

        // 지훈이의 이동 BFS
        while (!Q2.isEmpty()) {
            int[] cur = Q2.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) { // 탈출 성공
                    System.out.println(dist2[cur[0]][cur[1]] + 1);
                    return;
                }
                if (dist2[nx][ny] >= 0 || board[nx].charAt(ny) == '#') continue;
                if (dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur[0]][cur[1]] + 1) continue;
                dist2[nx][ny] = dist2[cur[0]][cur[1]] + 1;
                Q2.add(new int[]{nx, ny});
            }
        }

        // 탈출 실패
        System.out.println("IMPOSSIBLE");
    }
}
