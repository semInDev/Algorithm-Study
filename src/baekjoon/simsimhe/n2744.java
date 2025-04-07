package baekjoon.simsimhe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://propercoding.tistory.com/229

public class n2744 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
        	char c = str.charAt(i);
        	if(Character.isLowerCase(c)) {
        		sb.append(Character.toUpperCase(c));
        	}else {
        		sb.append(Character.toLowerCase(c));
        	}
        }
        System.out.print(sb);

	}

}
