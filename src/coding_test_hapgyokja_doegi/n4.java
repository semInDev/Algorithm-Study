package coding_test_hapgyokja_doegi;
import java.util.*;

public class n4 {
    public int[] solution(int[] answers) {
        int[][] patterns = {{1, 2, 3, 4, 5},
                            {2, 1, 2, 3, 2, 4, 2, 5},
                            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] score = new int[3];
        
        //socre 카운트하기
        for(int i=0; i<answers.length; i++){
            for(int j=0; j<patterns.length; j++){
                if(answers[i] == patterns[j][i%patterns[j].length])
                    score[j]++;
            }
        }
        
        //max score인 사람 찾기
        List<Integer> arr = new ArrayList<>();
        int max_score = -1;
        for(int i=0; i<3; i++){
            if(score[i] > max_score)
                max_score = score[i];
        }
        for(int i=0; i<3; i++){
            if(score[i] == max_score)
                arr.add(i+1);
        }
        
        //return arr.toArray();
        /*
        /Solution.java:30: error
        : incompatible types: Object[] cannot be converted to int[]
        return arr.toArray();
        arr.toArray()가 반환하는 배열의 타입 때문입니다.
        이 메서드는 기본적으로 Object[]를 반환합니다.
        그러나 반환 타입이 int[]여야 하므로 타입 불일치로 인해 컴파일 오류가 발생합니다.
        */
        
        //따라서, 스트림으로 변환해야함!
        return arr.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
