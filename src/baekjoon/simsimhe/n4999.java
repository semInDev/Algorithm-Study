package baekjoon.simsimhe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n4999 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        String jae = br.readLine();
        String doc = br.readLine();
        if(jae.length()<doc.length()) {
        	System.out.println("no");
        }else {
        	System.out.println("go");
        }
	}

}
