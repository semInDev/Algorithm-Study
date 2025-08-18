package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n9663_re {
	static int N, result;
	static boolean[] isUsed1, isUsed2, isUsed3;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));        
        N = Integer.parseInt(br.readLine());
        
        isUsed1 = new boolean[N];
        isUsed2 = new boolean[2*N+1];
        isUsed3 = new boolean[2*N+1];
        
        backtracking(0);
        
        System.out.println(result);
	}
	
	private static void backtracking(int depth) {
		if(depth == N) {
			result++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(!isUsed1[i] && !isUsed2[depth + i] && !isUsed3[depth - i + N - 1]) {
				isUsed1[i] = true;
				isUsed2[depth + i] = true;
				isUsed3[depth - i + N - 1] = true;
				backtracking(depth+1);
				isUsed1[i] = false;
				isUsed2[depth + i] = false;
				isUsed3[depth - i + N - 1] = false;
			}
		}
	}

}
