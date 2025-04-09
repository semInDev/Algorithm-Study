package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n14956 {

    // 변의 길이, 걸어간 거리로 x, y좌표값을 재귀적으로 계산
    static int[] philo(int side, int walk) {
        // Base case: 변의 길이가 2^1인 경우
        if (side == 2) {
            switch (walk) {
                case 1:
                    return new int[]{1, 1};
                case 2:
                    return new int[]{1, 2};
                case 3:
                    return new int[]{2, 2};
                case 4:
                    return new int[]{2, 1};
            }
        }

        int half = side / 2;
        int section = half * half;

        // walk가 속하는 범위에 따라 계산
        if (walk <= section) {
            int[] rv = philo(half, walk);
            return new int[]{rv[1], rv[0]};
        } else if (walk <= 2 * section) {
            int[] rv = philo(half, walk - section);
            return new int[]{rv[0], half + rv[1]};
        } else if (walk <= 3 * section) {
            int[] rv = philo(half, walk - 2 * section);
            return new int[]{half + rv[0], half + rv[1]};
        } else {
            int[] rv = philo(half, walk - 3 * section);
            return new int[]{2 * half - rv[1] + 1, half - rv[0] + 1};
        }
    }

    public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int side = Integer.parseInt(st.nextToken());
        int walk = Integer.parseInt(st.nextToken());

        int[] ans = philo(side, walk);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
