package 정렬.HIndex;

import java.util.*;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=java
public class Main
{
    public static void main(String[] args)
    {//3, 0, 6, 1, 5
     //6, 5, 3, 1, 0
     //1  2  3  4
       //
        Solution.solution(new int[]{3,0,6,1,5});

     //10, 0, 3, 1, 0
     //10, 3, 1, 0, 0
     //1   2  3  4  5
        Solution.solution(new int[]{6,5,7});
    }
}
class Solution {
    public static int solution(int[] citations) {
        int answer = 0;
        List<Integer> list = Arrays.stream(citations)
            .boxed()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());

        for(int i=0; i<list.size(); i++){
            if(i+1<= list.get(i)){ //i+1 이상인지
                answer++;
            }
        }

        return answer;
    }
}