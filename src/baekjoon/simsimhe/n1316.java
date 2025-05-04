package baekjoon.simsimhe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 어차피 알파벳이니까 배열로 해도 될 듯
 * hashset을 사용해도 되는데
 * 배열이 더 효율적임
 * */

public class n1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(N-->0) {
			String str = br.readLine();
			
			// 알파벳이.. 몇 개지? 모르니까 일단 코딩
			int[] chars = new int['z' - 'a' + 1];
			boolean groupWord = true;
			for(int i=0; i<str.length(); i++) {
				// 앞이랑 다른 문자인데, 이미 나온 문자(1)다? 그룹문자 아님!
				int idx = str.charAt(i) - 'a';
				if(chars[idx] == 0) {
					chars[idx] = 1;
				}
				else if(str.charAt(i-1) != str.charAt(i) && chars[idx] == 1){
					groupWord = false;
					break;
				}
				// 2일 때는 그냥 패스
			}
			if(groupWord) cnt++;
		}
		
		System.out.println(cnt);
	}

}
