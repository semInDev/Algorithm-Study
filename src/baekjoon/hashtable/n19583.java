package baekjoon.hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n19583 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        
        HashSet<String> entry = new HashSet<>();
        HashSet<String> exit = new HashSet<>();
        String str = null;
        while((str = br.readLine()) != null) {
        	String[] arr = str.split(" ");
        	String time = arr[0];
        	String name = arr[1];
        	if(S.compareTo(time) >= 0) {
        		entry.add(name);
        	}
        	if(E.compareTo(time)<=0 && Q.compareTo(time)>=0) {
        		exit.add(name);
        	}
        }
        int count = 0;
        for(String name : entry) {
        	if(exit.contains(name))
        		count++;
        }
        System.out.println(count);
	}

}
