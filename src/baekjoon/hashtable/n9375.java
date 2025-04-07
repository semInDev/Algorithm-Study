package baekjoon.hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n9375 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0) {
        	HashMap<String,Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            while(n-->0) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 옷 이름은 필요없음.
                String kind = st.nextToken();
                if(map.containsKey(kind)) {
                	map.put(kind, map.get(kind)+1);
                }else {
                	map.put(kind, 1);
                }
            }
            int result = 1;
            for(int num : map.values()) {
            	result *= (num+1);
            }
            sb.append((result-1) + "\n");
        }
        System.out.print(sb);
	}

}
