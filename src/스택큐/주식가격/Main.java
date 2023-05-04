package 스택큐.주식가격;

import java.util.LinkedList;
import java.util.Queue;
//https://school.programmers.co.kr/learn/courses/30/lessons/42584

public class Main {
    public static void main(String[] args) {
        Solution.solution(new int[] {1, 2, 3, 1, 3});
    }
}
class Solution {
    public static int[] solution(int[] prices) {
//        1, 2, 3, 2, 3
/*
1 -> 1보다 작냐? x ->  2,3,2,3 = 4초
2 -> 2보다 작냐? x -> 3,2,3 = 3초
3 -> 3보다 작냐? O -> 1초
2 -> 2보다 작냐? x -> 1초
3 -> 0

1 2 3
* */
        int[] answer = new int[prices.length];

        for(int i=0; i< prices.length; i++){
            int count = 0;
            for(int j=i+1; j< prices.length; j++){
                count++;
                if(prices[i]>prices[j]){
                    answer[i] = count;
                    break;
                }
                else if(j == prices.length-1){
                    answer[i] = count;
                }
            }
        }
        return answer;
    }
}