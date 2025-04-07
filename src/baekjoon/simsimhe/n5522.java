package baekjoon.simsimhe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n5522 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        for(int i=0; i<5; i++) {
        	result += Integer.parseInt(br.readLine());
        }
        System.out.println(result);
	}

}
