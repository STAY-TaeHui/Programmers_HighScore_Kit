package 힙.디스크컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42627
public class Main
{
    public static void main(String[] args)
    {
//[[0, 3], [1, 9], [2, 6]]
        Solution.solution(new int[][]{{0, 5}, {1, 2}, {2, 7}, {3, 3}});
    }
}
class Solution {
    public static int solution(int[][] jobs) {
        int answer = 0;
        Queue<Integer> queue = Arrays.stream(jobs)
            .map(j -> j[1])
            .collect(Collectors.toCollection(PriorityQueue::new));


        return answer;
    }
}