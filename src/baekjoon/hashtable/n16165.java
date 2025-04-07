package baekjoon.hashtable;

import java.io.*;
import java.util.*;

public class n16165 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        HashMap<String, String[]> toName = new HashMap<>(); // 정렬만 해주면 되니까 String 배열로 결정
        HashMap<String, String> toTeam = new HashMap<>();
        while(N-->0) {
        	String teamName = br.readLine();
        	int num = Integer.parseInt(br.readLine());
        	String[] members = new String[num];
        	for(int i=0; i<num; i++) {
        		String name = br.readLine();
        		members[i] = name;
        		toTeam.put(name, teamName);
        	}
        	Arrays.sort(members);
        	toName.put(teamName, members);
        }
        
        StringBuilder sb = new StringBuilder();
        while(M-->0) {
        	String input = br.readLine();
        	int cmd = Integer.parseInt(br.readLine());
        	if(cmd == 1) {
        		sb.append(toTeam.get(input)+"\n");
        	}else {
        		for(String str : toName.get(input)) {
        			sb.append(str+"\n");
        		}
        	}
        }
        System.out.print(sb);
	}

}
