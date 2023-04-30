package 스택큐.프로세스;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//https://school.programmers.co.kr/learn/courses/30/lessons/42587
public class Main {
    public static void main(String[] args) {
        Solution.solution(new int[] {1, 1, 9, 1, 1, 1}, 0);
    }
}

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> priorList = Arrays.stream(priorities)
                .boxed()
                .collect(Collectors.toList());
        //2 1 0 2

        Queue<Integer> indexQ = IntStream.range(0, priorities.length)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        // 0 1 2 3

        while (true) {
            Integer max = priorList.stream().max(Integer::compareTo).get(); //List 내의 최대 값
            int next = indexQ.poll();
            if (!priorList.get(next).equals(max)) {// next 인덱스와 max값과 비교
                indexQ.offer(next); // 값이 다르면 Queue에 다시 넣어줌
            } else {
                answer++; // Queue에서 빠진 횟수
                priorList.set(next,0); // 빠진 인덱스를 List에서 0으로 만듬
                if (next == location) {
                    return answer;
                }
            }

        }

    }
}