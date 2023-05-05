package 스택큐.주식가격;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//https://school.programmers.co.kr/learn/courses/30/lessons/42584

public class Main {
    public static void main(String[] args) {
        Solution.solution2(new int[] {8,10,2,3,9});
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

        //2중 for문
        //
        for(int i=0; i< prices.length; i++){
            int count = 0;
            for(int j=i+1; j< prices.length; j++){
                count++;//현재 인덱스 i 와 for문 j 를 돌면서 비교.
                        //count : 얼마나 시간이 지났는지
                if(prices[i]>prices[j]){//가격이 떨어졌을때
                    answer[i] = count;// 배열에 기록하고 for문 종료
                    break;
                }
                else if(j == prices.length-1){// 배열 마지막까지 갔을때
                    answer[i] = count;
                }
            }
        }
        return answer;
    }
    public static int[] solution2(int [] prices){
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<len; i++){ // prices 배열의 크기동안

            //비교대상stack 인덱스의 price값이 현재 비교중인 인덱스의 price값보다 작다면
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                //떨어졌을때 실행
                //stack에서 해당값은 빼주고
                int idx = stack.pop();
                //answer 인덱스에 얼마만에 찾았는지 넣어준다.
                answer[idx] = i - idx;
            }
            stack.push(i);
        }
        System.out.println(stack);

        while(!stack.isEmpty()){
            int leftIdx = stack.pop();
            answer[leftIdx] = len-leftIdx-1;
        }

        return answer;
    }
}