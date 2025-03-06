package icoda.greedy;
import java.io.*;

//O(N): 문자열 길이 < 10만
public class q3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		//변수 4개 or HashMap or int[]로 표현 가능할 듯
		int[] cnt = new int[2];//0,1의 cnt 
		int turn = Integer.parseInt(str.charAt(0)+"");
		
		for(int i=1; i<str.length(); i++) {
			int cur = Integer.parseInt(str.charAt(i)+"");
			if(cur != turn) {//turn 바꾸기 + cnt 늘리기
				cnt[turn]++;
				turn = cur;
			}
		}
		cnt[turn]++;
		
		System.out.println(Math.min(cnt[0], cnt[1]));
	}
}
