package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class n2961 {
	static int N;
	static String[][] input;
	static BigInteger squareS = new BigInteger("1");
	static BigInteger sumB = new BigInteger("0");
	static BigInteger output = BigInteger.valueOf((int)Math.pow(10, 90));

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));        
        
		N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        input = new String[N][2];
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	input[i][0] = st.nextToken();
        	input[i][1] = st.nextToken();
        }
        
        for(int i=1; i<N+1; i++) {
        	bt(0, i, -1);
        }
        
        System.out.println(output);
	}
	
	private static void bt(int depth, int total, int preIdx) {
		if(depth == total) {
			BigInteger result = squareS.subtract(sumB);
			if(squareS.compareTo(sumB)==-1) {
				result = result.multiply(new BigInteger("-1"));
			}
			if(result.compareTo(output)==-1) {
				output = result;
			}
			return;
		}
		
		for(int i=preIdx+1; i<N; i++) {
			squareS = squareS.multiply(new BigInteger(input[i][0]));
			sumB = sumB.add(new BigInteger(input[i][1]));
			bt(depth+1, total, i);
			squareS = squareS.divide(new BigInteger(input[i][0]));
			sumB = sumB.subtract(new BigInteger(input[i][1]));
		}
	}

}
