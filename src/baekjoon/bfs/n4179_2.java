package baekjoon.bfs;

import java.io.*;
import java.util.*;

public class n4179_2 {

	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] raw_graph = new char[R][C];
		for(int i=0;i<R;i++) {
			String str = br.readLine();
			for(int j=0;j<C;j++) {
				raw_graph[i][j] = str.charAt(j);
			}
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int[][] graphJ = new int[R][C];
		int[][] graphF = new int[R][C];
	}

}
