package baekjoon.hashtable;

import java.io.*;
import java.util.*;

public class n13414ex {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i = 0; i < L; i++) {
            String num = br.readLine();
            if (set.contains(num)) {
                set.remove(num); // 기존꺼 지우고
            }
            set.add(num); // 맨 뒤에 다시 넣기
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String num : set) {
            if (count == K) break;
            sb.append(num).append("\n");
            count++;
        }

        System.out.print(sb);
	}

}
