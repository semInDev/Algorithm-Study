package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n14888 {
	static int N, maxResult=-1000000000, minResult=1000000000;
	static int[] operands;
	static int[] operators = new int[4];
	
	public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        operands = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	operands[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
        	operators[i] = Integer.parseInt(st.nextToken());
        }
        
        backtracking(1,operands[0]);
        
        System.out.println(maxResult+"\n"+minResult);
	}
	
	private static void backtracking(int depth, int tmpResult) {
		if(depth == N) {
			if(maxResult < tmpResult) {
				maxResult = tmpResult;
			}
			if(minResult > tmpResult) {
				minResult = tmpResult;
			}
			return;
		}
		for(int i=0; i<4; i++) {
			if(operators[i] >= 1) {
				int nxtTmpResult = calculation(tmpResult, operands[depth], i);
				operators[i]--;
				backtracking(depth+1, nxtTmpResult);
				operators[i]++;
			}
		}
	}
	
	private static int calculation(int x, int y, int operatorIdx) {
		switch(operatorIdx) {
		case 0: return x+y;
		case 1: return x-y;
		case 2: return x*y;
		default: return x/y; // case 3
		}
	}

}
