package baekjoon.recursion;

import java.util.*;
import java.io.*;

public class n1629 {

	private static long power(long x, long n, long C) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0)
			return power((x * x) % C, n / 2, C);
		else
			return (power((x * x) % C, (n - 1) / 2, C) * (x % C)) % C;
	}

	/* [참고한 풀이] https://st-lab.tistory.com/237
	 * private static long power(long A, long exponent, long C) { // 지수가 1일 경우 A^1
	 * 이므로 A를 그대로 리턴 if (exponent == 1) { return A % C; }
	 * 
	 * // 지수의 절반에 해당하는 A^(exponent / 2) 을 구한다. long temp = power(A, exponent / 2,
	 * C);
	 * 
	 * 
	 * 현재 지수가 홀 수 였다면 A^(exponent / 2) * A^(exponent / 2) * A 이므로 A를 한 번 더 곱해주어야 한다.
	 * 
	 * ex) A^9 = A^4 * A^4 * A
	 * 
	 * if (exponent % 2 == 1) { return (temp * temp % C) * A % C; } return temp *
	 * temp % C;
	 * 
	 * }
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		System.out.println(power(A, B, C));
	}

}
