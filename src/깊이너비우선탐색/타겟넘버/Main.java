package 깊이너비우선탐색.타겟넘버;

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
    static boolean[] check ;
    static int sum=0;
    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        check= new boolean[numbers.length];
        dfs(1,  numbers, target);

        return answer;
    }
    public static void dfs(int depth, int [] numbers, int target){
        if(depth>numbers.length){// 다 더했을때
            if(sum == target){
                answer++;
                return;
            }
            else return;
        }
        for(int i=0; i<numbers.length; i++){
            if(!check[i]){
                check[i] = true;
                sum+=numbers[i];
                dfs(depth+1, numbers, target);
                sum -= numbers[i]*2;// 기존 넣었던거 빼기 + 음수로 바꿔서 더하기 ==> *2
                dfs(depth+1, numbers, target);

                sum += numbers[i];// 음수 더했던거 다시 돌리기
                check[i] = false;
            }

        }
    }
}