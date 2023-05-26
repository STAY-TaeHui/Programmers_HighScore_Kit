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
    static Stack<Integer> st = new Stack<>();

    public static int solution(int[] numbers, int target) {

        dfs(0, numbers, target);

        return answer;
    }
    /*
    * depth : 재귀 호출 횟수 -> numbers의 index로 사용
    * numbers
    * target
    * */
    public static void dfs(int depth, int[] numbers, int target){
        if(numbers.length==st.size()){ // 스택이 꽉 차면, SUM 구해준다.
            int sum = st.stream().mapToInt(Integer::intValue).sum();
            if(target == sum){
                System.out.println(depth +" " + target + " " + sum);
                answer++;
            }
        }
        else{
            st.push(numbers[depth]); // 양수일 때 push
            dfs(depth + 1, numbers, target);
            st.push(st.pop() * -1);// 음수 일 때 push
            dfs(depth + 1, numbers, target);

            st.pop();// 한 숫자에 대한 양수/음수 push 가 끝나면 pop
        }
    }
}
/*
0 1 2 3
4
  1
    2
       1  --> SUM 계산
      -1  --> SUM 계산

    -2
       1  --> SUM 계산
      -1  --> SUM 계산

  -1
     2
        1  --> SUM 계산
       -1  --> SUM 계산

    -2
        1  --> SUM 계산
       -1  --> SUM 계산

* */