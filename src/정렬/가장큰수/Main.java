package 정렬.가장큰수;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
public class Main
{
    public static void main(String[] args)
    {
//        3, 30, 34, 5, 9
        Solution.solution(new int[]{0,0,0});
    }
}
// 1. 첫번째 자리를 기준으로 정렬
// - 9, 5, 3, 30, 34
// 2. 첫번째 자리가 같은 경우 두번째 숫자와 비교
// 2.1 자리수가 작은 숫자를 기준으로 비교함. -> 3이 기준
// 2.2 두번째 자리가 3보다 작으면 뒤로, 크면 앞으로, 같으면 자리수 작은게 앞으로
// - 9, 5, 34, 3, 30

// 432, 43, 32, 4, 2, 433
// 1. 432, 43, 4, 433, 32, 2
// 2.1 4가 기준이고, 한자리와 두자리 먼저 비교
// 2.2 두번째 자리가 4보다 크면 앞, 작으면 뒤, 같으면 자리수 작은게 앞으로
// - 4, 43, 433, 432 32 2
// -
class Solution {
    public static String solution(int[] numbers) {
//        6, 10, 2
//        1. (6, 10) -> 106 compareTo 610
        String answer =
        Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((o1, o2) -> (o2+o1).compareTo(o1+o2)) //3430 3034
            .collect(Collectors.joining());

        if(answer.charAt(0) == '0'){
            return "0";
        }

        return answer;
    }
}