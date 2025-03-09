package icoda.dp;
import java.util.*;

//BFS 숨바꼭질 문제 풀이 응용
public class ch8_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] dx = {5, 3, 2};
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		int[] arr = new int[n+1];//0은 더미
		Arrays.fill(arr, -1);
		arr[n] = 0;
		
		while(arr[1]==-1) {
			//queue에서 하나 꺼내서 4가지 경우의 수 진행 후 queue에 또 넣기
			//꺼내서 다음 것 시행 전에 -1이 아닌 경우만 큐에 넣기
			//이번 꺼 수에 +1하면 됨
			int cur = queue.poll();
			for(int i=0; i<dx.length; i++) {
				if(cur % dx[i] == 0 && arr[cur/dx[i]] == -1) {
					arr[cur/dx[i]] = arr[cur] + 1;
					queue.add(cur/dx[i]);
				}
			}
			if(arr[cur-1] == -1) {
				arr[cur-1] = arr[cur] + 1;
				queue.add(cur-1);
			}
		}
		
		System.out.println(arr[1]);
		sc.close();
	}

}
