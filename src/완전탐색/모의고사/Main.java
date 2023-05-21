package 완전탐색.모의고사;

import java.util.*;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class Main
{
    public static void main(String[] args)
    {
    }
}
class Solution {
    Map<String,Integer> correctCount = new HashMap<>();
    Map<String, int []> nameMap = new HashMap<>();
    public int[] solution(int[] answers) {
        nameMap.put("1",new int[]{1,2,3,4,5});
        nameMap.put("2",new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        nameMap.put("3",new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        for(int i=0; i<answers.length; i++){
            marking("1",i,answers[i]); //정답체크
            marking("2",i,answers[i]);//정답체크
            marking("3",i,answers[i]);//정답체크
        }
        return correctCount.entrySet().stream()
                .filter(m -> m.getValue().equals(
                        correctCount.values().stream()
                        .max(Integer::compareTo) // 최대값 뽑아서
                        .get())
                )
                .mapToInt(m -> Integer.parseInt(m.getKey())) //최대값인 Key만 뽑아서
                .toArray(); // 배열로 만듬

    }
    public void marking(String name, int i, int ans){
        int[] nameAnswer = nameMap.get(name);
        if(nameAnswer[i % nameAnswer.length] == ans)
            correctCount.put(name,correctCount.getOrDefault(name,0)+1);
    }
}