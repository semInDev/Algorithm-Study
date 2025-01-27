package baekjoon.bst;
import java.util.*;
import java.io.*;

public class n7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			TreeSet<Integer> bst = new TreeSet<>((o1,o2)->o2.compareTo(o1));
			//같은 수가 들어가는 예외가 발생할 수 있음 -> 같은 수가 들어가면 이를 따로 기록해주는 방법도 있음
			int k = Integer.parseInt(br.readLine());
			while(k-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(cmd.equals("I")) {
					bst.add(num);
				}else {//cmd == "D"
					if(bst.isEmpty())
						continue;
					else if(num == 1) {
						bst.pollFirst();
					}else {//num==-1
						bst.pollLast();
					}
				}
			}
			if(bst.isEmpty())
				sb.append("EMPTY\n");
			else {
				sb.append(bst.first()+" "+bst.last()+"\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

}
