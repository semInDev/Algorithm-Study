package baekjoon.bfs;
import java.util.*;
import java.io.*;

public class n1697 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] dis = new int[100001];
        Arrays.fill(dis, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        dis[N] = 0;
        while(dis[K] == -1) {
        	int cur = queue.poll();
        	for(int nxt : new int[] {cur-1, cur+1, cur*2}) {
        		if(0<=nxt && nxt<dis.length && dis[nxt] == -1) {
        			dis[nxt] = dis[cur] + 1;
        			queue.add(nxt);
        		}
        	}
        }
        System.out.println(dis[K]);
	}
}
