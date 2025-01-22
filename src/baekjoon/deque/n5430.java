package baekjoon.deque;
import java.util.*;
import java.io.*;

public class n5430 {
	/* [250122]
	 * 1. 로직 시간초과
	 * 뒤집기를 구현하는 과정에서의 시간복잡도에 신경썼다.
	 * 스택(덱도 가능)을 이용한 뒤집기 방법을 생각하고,
	 * 뒤집기에 대한 시간복잡도를 단순히 O(2N)이라고만 생각했다.
	 * 하지만 뒤집기 명령을 N번만큼 할 수 있기에
	 * O(N^2)이 될 수 있었다. 
	 * 
	 * => 스택이 아닌 덱만이 할 수 있는 로직!
	 * 뒤집기 시 뺴는 방향을 반대로 바꾸기!
	 * 
	 * 2. [1,2,3,34,56,6]를 입력받는 코드 구현 에러
	 * 3. output도 같은 형태로 만드는 것 구현 에러
	 * => 낯선 부분이라서 틀렸지만,
	 * 코테만 놓고보면 input/output String 조작에서는 실망하지 않아도 될 것 같음
	 * 근데, 실망하지 말라는 말이지 공부하지 말라는 말은 아님..!
	 * */
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int test = Integer.parseInt(br.readLine());
		while(test-->0) {
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			
			String cmds = br.readLine();
			br.readLine();//필요없음
			String inputArr = br.readLine();
			inputArr = inputArr.substring(1,inputArr.length()-1);//[ ]제거
			if(inputArr.length()!=0) {
				String[] elements = inputArr.split(",");
				for(String e : elements) {
					deque.addLast(Integer.parseInt(e));
				}
			}

			boolean direction = false; //false: front, true: back;
			boolean error = false;
			for(int i=0; i<cmds.length(); i++) {
				char cmd = cmds.charAt(i);
				if(cmd == 'R') {
					if(direction) {//back
						direction = false;
					}else {//front
						direction = true;
					}
				}else {//'D'
					if(deque.isEmpty()) {
						error = true;
						break;
					}else if(direction){//back
						deque.pollLast();
					}else {//front
						deque.pollFirst();
					}
				}
			}
			
			if(error) {
				sb.append("error\n");
			}else {
				sb.append("[");
				if(direction) {//back
					while(!deque.isEmpty()) {
						if(deque.size()==1) {
							sb.append(deque.pollLast());
						}else {
							sb.append(deque.pollLast()+",");
						}
					}
				}else {//front
					while(!deque.isEmpty()) {
						if(deque.size()==1) {
							sb.append(deque.pollFirst());
						}else {
							sb.append(deque.pollFirst()+",");
						}
					}
				}
				//sb.delete(sb.length()-1, sb.length());//쉼표 하나 삭제 -> []처럼 빈 문자열은 에러 발생
				sb.append("]\n");
			}
			
		}
		System.out.print(sb);
		br.close();
		
	}

}
