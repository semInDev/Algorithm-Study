package baekjoon.simsimhe;

import java.io.*;
import java.util.*;

public class n9295 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<T+1; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	sb.append("Case "+i+": "+(a+b)+"\n");
        }
        System.out.print(sb);
	}
}
