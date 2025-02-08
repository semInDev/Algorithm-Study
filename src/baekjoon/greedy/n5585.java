package baekjoon.greedy;
import java.io.*;
public class n5585 {

    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int left = 1000 - price;
        int cnt = 0;
        int[] coinTypes = {500, 100, 50, 10, 5};
		
        for (int i = 0; i < coinTypes.length; i++) {
            int coin = coinTypes[i];
            cnt += left / coin;
            left %= coin;
        }
        cnt += left;//1엔

        System.out.println(cnt);
    }

}