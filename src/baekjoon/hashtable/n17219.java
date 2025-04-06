package baekjoon.hashtable;

import java.io.*;
import java.util.*;

public class n17219 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, String> map = new HashMap<>();
        while(N-->0) {
        	st = new StringTokenizer(br.readLine());
        	String site = st.nextToken();
        	String pw = st.nextToken();
        	map.put(site, pw);
        }
        
        StringBuilder sb = new StringBuilder();
        while(M-->0) {
        	String inputSite = br.readLine();
        	sb.append(map.get(inputSite)+"\n");
        }
        System.out.print(sb);
	}

}
