package icoda.greedy;
import java.util.*;

//O(N): 문자열 길이 < 10만
public class q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		//변수 4개 or HashMap or int[]로 표현 가능할 듯
		int[][] cnt = new int[2][2];//0,1의 cnt, temp 
		int turn = Integer.parseInt(str.charAt(0)+"");
		cnt[turn][1]++;//temp
		
		for(int i=1; i<str.length(); i++) {
			int cur = Integer.parseInt(str.charAt(i)+"");
			if(cur == turn) {//temp++하기
				cnt[turn][1]++;
			}else {//turn 바꾸기 + cnt 늘리고 + temp 초기화
				cnt[turn][0]++;
				cnt[turn][1] = 0;
				turn = cur;
			}
		}
		cnt[turn][0]++;
		
		System.out.println(Math.min(cnt[0][0], cnt[1][0]));
		sc.close();
	}

}
