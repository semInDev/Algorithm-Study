package baekjoon.ds;

import java.io.*;

// Stack을 꼭 써야 할까? pre와 cur 변수만 있으면 될 것 같은데
public class n10799 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char pre = str.charAt(0); // 처음은 무조건 (
		int count = 1; // 지금까지 stack에 남은 ( 개수
		int result = 0;
		char cur;
		for(int i=1; i<str.length(); i++) {
			cur = str.charAt(i);
			if(cur == '(')
				count++;
			else if(pre == '(' && cur == ')') { // 레이저
				count--; // 통나무 count가 아니라 레이저였기 때문에
				result += count;
			}
			else if(pre == ')' && cur == ')'){ // 통나무 끝
				count--;
				result++;
			}
			pre = cur;
		}
		System.out.println(result);

	}

}
