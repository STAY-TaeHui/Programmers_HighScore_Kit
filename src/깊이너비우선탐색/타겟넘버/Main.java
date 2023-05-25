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
class Solution {
    static int answer = 0;
    public static int solution(int[] numbers, int target) {
        dfs(0,  numbers, target,0);

        return answer;
    }
    public static void dfs(int depth, int [] numbers, int target, int sum){
        if (depth == numbers.length){
            if(sum==target) answer++;
        }else{
            dfs(depth+1, numbers,target,sum+numbers[depth]);
            dfs(depth+1, numbers,target,sum-numbers[depth]);

        }
    }
}