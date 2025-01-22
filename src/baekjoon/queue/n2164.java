package baekjoon.queue;
import java.util.*;
import java.io.*;

public class n2164 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<N+1; i++) {
			queue.add(i);
		}
		
		int step = 0;//짝수: 버리기, 홀수: 뒤로 넣기
		while(queue.size()>1) {
			if(step%2==0) {
				queue.poll();
			}else {
				int temp = queue.poll();
				queue.add(temp);
			}
			step++;
		}
		System.out.println(queue.poll());
	}

}
