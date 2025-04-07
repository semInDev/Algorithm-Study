package baekjoon.simsimhe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n3003 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {1,1,2,2,2,8};
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<arr.length; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	System.out.print(arr[i]-num+" ");
        }

	}

}
