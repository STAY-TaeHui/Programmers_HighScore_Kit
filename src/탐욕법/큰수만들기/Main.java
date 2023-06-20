package 탐욕법.큰수만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42883
public class Main {
    public static void main(String[] args) {
//        Solution.solution("1924",2);//94
        Solution.solution("1231234",3);//3234
//        Solution.solution("4177252841",4);//775841
//        Solution.solution("67429495152",3);//94
//        Solution.solution("928857066163493066555730841879",7);//98876693066555730841879

    }
}
class Solution{
    public static String solution(String number, int k)
    {//https://born2bedeveloper.tistory.com/27참고
        //4177252841 len=10 k=4
//        417725 2841 start=0 end=6
//        7 - 7252 841 start=3 end=7
//        77 - 2528 41 start=3 end=7

        //1231234 len=7 k-3
//        1231 234  start=0 end=4
//        3 - 12 34 start=3 end=5
//        32 - 3 4 start=5 end=6
//        323 - 4 start=6 end=7
//        3234
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = k+1;
        while(sb.length()!=number.length()-k){
            int max = 0;

            for(int i=start; i<end; i++){
                if(max<number.charAt(i)-'0'){
                    max = number.charAt(i)-'0';
                    start=i;
                }
            }
            start++;
            end++;
            sb.append(max);
        }
        System.out.println(sb.toString());
        return sb.toString();

        /*String answer = "";
        int count = 0;
        List<Character> numbers = number.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for(int i=1; i<numbers.size()-1 && count!=k; i++){
            if(numbers.get(0)<numbers.get(1))//맨 왼쪽 숫자가 그 다음숫자보다 작은지 체크
            {// 왼쪽이 작으면 제거
                numbers.remove(0);
                count++;
                i=0;
                continue;
            }
            if(numbers.get(i-1)>numbers.get(i) && numbers.get(i+1)>numbers.get(i)){//왼쪽과 오른쪽 체크
                numbers.remove(i);
                count++;
                i=0;
            }
        }
        for(int i=numbers.size()-1; i>0 && count!=k; i--){
            if(numbers.get(i)<=numbers.get(i-1)){
                numbers.remove(i);
                count++;
                i=numbers.size();
            }
        }
        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining()));
        return numbers.stream().map(String::valueOf).collect(Collectors.joining());*/

    }
}