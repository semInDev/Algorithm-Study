package baekjoon.hashtable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n11478 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<str.length(); i++) {
        	for(int j=i+1; j<str.length()+1; j++) {
        		set.add(str.substring(i, j));
        	}
        }
        System.out.println(set.size());
	}

}
