package baekjoon.simsimhe;

import java.io.*;
import java.util.*;

public class n2420 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        System.out.println(Math.abs(N-M));
	}

}
