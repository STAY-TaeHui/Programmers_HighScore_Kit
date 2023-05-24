package 깊이너무우선탐색.타겟넘버;

import java.util.Stack;

//https://school.programmers.co.kr/learn/courses/30/lessons/43165
public class Main
{
    public static void main(String[] args)
    {
        Solution.solution(new int[]{4,1,2,1}, 4);
    }
}
//[4, 1, 2, 1]	4	2
/*
    +4+1-2+1 = 4
    +4-1+2-1 = 4
* */
//[2, 3, 1] 2
//-2 3 1
//
class Solution {
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        boolean[] check = new boolean[numbers.length];

        for(int i=0; i<numbers.length; i++){
            if(!check[i]){
                sum += numbers[i];
                st.push(numbers[i]);

            }
//            4+1+2+1    4 1 2 1
//            4+1+2-1
//            4+1-2
        }
        return answer;
    }
}