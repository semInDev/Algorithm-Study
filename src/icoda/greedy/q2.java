package icoda.greedy;
import java.util.*;

//O(N): N = str 길이 <= 20
public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int result = Integer.parseInt(str.charAt(0)+"");
		int current;
		for(int i=1; i<str.length(); i++) {
			current = Integer.parseInt(str.charAt(i)+"");
			/*if(result == 0 || result == 1
					|| current == 0 || current == 1) {*/
			if(result <= 1 || current <= 1) {
				result+=current;
			}else {
				result*=current;
			}
		}
		
		System.out.println(result);
		sc.close();
	}

}
