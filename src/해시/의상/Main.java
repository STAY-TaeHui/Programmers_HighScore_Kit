package 해시.의상;
//https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;

public class Main
{
    public static void main(String[] args) {
//        Solution.solution(new String[][] {{"1", "a"}, {"2", "a"}, {"3", "a"}, {"1", "b"}, {"2", "b"}});
        Solution.solution(new String[][] {{"1", "b"}, {"2", "a"}, {"3", "c"}, {"1", "d"}, {"2", "e"}});

    }
}

class Solution {
    public static int solution(String[][] clothes) {
        Map<String,List<String>> map = new HashMap<>();

        for(String[] c : clothes){
            map.put(c[1],map.getOrDefault(c[1],new ArrayList<>()));
            map.get(c[1]).add(c[0]);
        }
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        int category = 1;
        while(iterator.hasNext()){
            Map.Entry<String, List<String>> next = iterator.next();
            int size = next.getValue().size();
            category *= size+1;
        }
        return category-1;
    }
}