package baekjoon.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2304 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));        
        
		int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        
        StringTokenizer st;
        int maxIdx = 0;
        int start = Integer.MAX_VALUE;
        int end = 0;
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	int L = Integer.parseInt(st.nextToken());
        	int H = Integer.parseInt(st.nextToken());
        	
        	arr[L] = H;
        	if(arr[maxIdx] < arr[L]) maxIdx = L;
        	start = Math.min(start, L);
        	end = Math.max(end, L);
        }
        
        int ans = arr[maxIdx];
        int curIdx = start;
        for(int nxtIdx = start+1; nxtIdx<maxIdx; nxtIdx++) {
        	if(arr[nxtIdx] != 0 && arr[curIdx] < arr[nxtIdx]) {
        		ans += (nxtIdx - curIdx) * arr[curIdx];
        		curIdx = nxtIdx;
        	}
        }
        ans += (maxIdx - curIdx) * arr[curIdx];
        
        curIdx = end;
        for(int nxtIdx = end; nxtIdx>maxIdx; nxtIdx--) {
        	if(arr[nxtIdx] != 0 && arr[curIdx] < arr[nxtIdx]) {
        		ans += (curIdx - nxtIdx) * arr[curIdx];
        		curIdx = nxtIdx;
        	}
        }
        ans += (curIdx - maxIdx) * arr[curIdx];
        
        System.out.println(ans);
	}

}
