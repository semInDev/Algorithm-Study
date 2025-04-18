package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n1339 {

	public static void main(String[] args)throws IOException {
 
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        /*
         * 이렇게 저장할 거임(e=empty)
			e e e e e GCF
			e e e ACDEB
		*/
        char[][] words = new char[N][8];
        for(int i=0; i<N; i++) { // O(N*8): N은 최대 10
        	String word = br.readLine();
        	for(int j=8-word.length(); j<8; j++) {
        		words[i][j] = word.charAt(word.length()-(8-j));
        	}
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        int num = 9;
        for(int i=0; i<8; i++) {
        	for(int j=0; j<N; j++) {
        		if(words[j][i]<'A' || words[j][i]>'Z') continue;
        		// 해당 값이 이미 map에 있으면 넘기기
        		if(map.containsKey(words[j][i])) continue;
        		// 해당 값이 map에 없으면 배정해주기
        		map.put(words[j][i], num--);
        	}
        }
        
        // 값 다 배정하면서 합치기
        int result = 0;
        for(int i=0; i<N; i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j=0; j<8; j++) {
        		if(words[i][j]<'A' || words[i][j]>'Z') continue;
        		sb.append(map.get(words[i][j]));
        	}
        	result += Integer.parseInt(sb+"");
        }
        System.out.println(result);
	}

}
