package baekjoon.bst;
import java.util.*;
import java.io.*;

public class n7662_re {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			TreeMap<Integer, Integer> Q = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			while(k-->0) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0); // 이거 어캐함
				int num = Integer.parseInt(st.nextToken());
				
				if(cmd == 'I') {
					if(Q.containsKey(num)) {
						Q.put(num, Q.get(num) + 1);
					}else {
						Q.put(num, 1);
					}
				}else {
					if(Q.isEmpty()) {
						continue;
					}else if(num == 1) {
						if(Q.get(Q.lastKey()) == 1) {
							Q.remove(Q.lastKey());
						}else {
							Q.put(Q.lastKey(), Q.get(Q.lastKey()) - 1);
						}
					}else {
						if(Q.get(Q.firstKey()) == 1) {
							Q.remove(Q.firstKey());
						}else {
							Q.put(Q.firstKey(), Q.get(Q.firstKey()) - 1);
						}
					}
				}
			}
			if(Q.isEmpty()) {
				sb.append("EMPTY").append("\n");
			}else {
				sb.append(Q.lastKey()).append(" ").append(Q.firstKey()).append("\n");
			}
		}
		System.out.print(sb);
	}
}
