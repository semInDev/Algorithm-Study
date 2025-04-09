package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n5956 {

	static int cnt = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        partitioning(N, M);
        System.out.println(cnt);
        // 2로 나누고 나머지가 "0이면" 끝/"아니면" cnt에 1하고, 2로 나눈 값을 newRow, newCol로 재귀하기, 리턴은 필요없음. 
	}
	private static void partitioning(int row, int col) {
		if(row%2==0 || col%2==0) {
			return;
		}
		cnt++;
		partitioning(row/2, col/2);
		partitioning(row/2, col/2);
		partitioning(row/2, col/2);
		partitioning(row/2, col/2);
		return;
	}

}
