package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n16987 {
    static int N, maxCount = 0;
    static int[] durabilitys, weights;
    static boolean[] isCracked;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        durabilitys = new int[N];
        weights = new int[N];
        isCracked = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            durabilitys[i] = Integer.parseInt(st.nextToken());
            weights[i] = Integer.parseInt(st.nextToken());
        }

        bt(0, 0);

        System.out.println(maxCount);
    }

    private static void bt(int curIdx, int cnt) {
        maxCount = Math.max(maxCount, cnt);

        if (curIdx == N) {
            return;
        }

        if (!isCracked[curIdx]) {
            boolean hit = false; // 현재 계란으로 다른 계란을 한 번이라도 친 적 있는지 체크
            for (int i = 0; i < N; i++) {
                if (curIdx == i || isCracked[i]) {
                    continue;
                }
                hit = true;

                // 두 계란 내구도 감소
                durabilitys[i] -= weights[curIdx];
                durabilitys[curIdx] -= weights[i];

                boolean crackedI = false;
                boolean crackedCur = false;

                if (durabilitys[i] <= 0 && !isCracked[i]) {
                    isCracked[i] = true;
                    cnt++;
                    crackedI = true;
                }
                if (durabilitys[curIdx] <= 0 && !isCracked[curIdx]) {
                    isCracked[curIdx] = true;
                    cnt++;
                    crackedCur = true;
                }

                bt(curIdx + 1, cnt);

                // 원상복구
                if (crackedI) {
                    isCracked[i] = false;
                    cnt--;
                }
                if (crackedCur) {
                    isCracked[curIdx] = false;
                    cnt--;
                }

                durabilitys[i] += weights[curIdx];
                durabilitys[curIdx] += weights[i];
            }

            // 현재 계란이 다른 계란을 칠 수 없을 때(모두 깨져 있음), 그냥 넘어감
            if (!hit) {
                bt(curIdx + 1, cnt);
            }
        } else {
            // 현재 계란이 이미 깨져있으면 그냥 다음으로 진행
            bt(curIdx + 1, cnt);
        }
    }
}
