package baekjoon.recursive;
import java.io.*;

public class n11729 {
	static int count = 0;
	static StringBuilder sb = new StringBuilder();
	private static void hanoi(int n, int start, int mid, int end) {
		if(n==0) return;
		hanoi(n-1, start, end, mid);
		sb.append(start+" "+end+"\n");
		count++;
		hanoi(n-1, mid, start, end);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		hanoi(N, 1, 2, 3);
		System.out.println(count);
		System.out.print(sb);
	}

}
