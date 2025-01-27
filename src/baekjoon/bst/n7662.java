package baekjoon.bst;
import java.util.*;
import java.io.*;

public class n7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			TreeMap<Integer,Integer> bst = new TreeMap<>((o1,o2)->o2.compareTo(o1));
			int k = Integer.parseInt(br.readLine());
			while(k-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if(cmd.equals("I")) {
					if(!bst.isEmpty() && bst.containsKey(num)) {
						bst.put(num, bst.get(num)+1);
					}else {
						bst.put(num, 1);
					}
				}else {//cmd == "D"
					if(bst.isEmpty())
						continue;
					else if(num == 1) {
						int first_num = bst.firstKey();
						if(bst.get(first_num)==1) {
							bst.pollFirstEntry();
						}else {
							bst.put(first_num, bst.get(first_num)-1);
						}
					}else {//num==-1
						int last_num = bst.lastKey();
						if(bst.get(last_num)==1) {
							bst.pollLastEntry();
						}else {
							bst.put(last_num, bst.get(last_num)-1);
						}
					}
				}
			}
			if(bst.isEmpty())
				sb.append("EMPTY\n");
			else {
				sb.append(bst.firstKey()+" "+bst.lastKey()+"\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

}
