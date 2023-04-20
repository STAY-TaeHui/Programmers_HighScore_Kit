package 해시.완주하지못한선수;
//https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=java

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) {
        Solution.solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"});
    }
}

class Solution {
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String,Integer> map = new HashMap<>();

        for(String par : participant){
            map.put(par,map.getOrDefault(par,0)+1);//map에 key:par 가 있으면 get value 해서 +1, 없으면 0
                                                                //map에 처음 값을 put 하는거기 때문에 무조건 default 타서 0
        }

        for(String com : completion){
            map.put(com,map.getOrDefault(com,0)-1);//map에 key:com이 있으면 get value 해서 -1
        }

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            if(next.getValue()!=0){
                answer = next.getKey();
                break;
            }
        }
        return answer;
    }
}