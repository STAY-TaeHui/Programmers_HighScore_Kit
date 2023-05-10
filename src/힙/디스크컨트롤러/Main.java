package 힙.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42627
public class Main
{
    public static void main(String[] args)
    {
//[[0, 3], [1, 9], [2, 6]]
        Solution.solution(new int[][]{ {1, 2}, {2, 7}, {0, 5}, {3, 3}});
    }
}
class Solution {
    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs);

        PriorityQueue<int[]> collect = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });




        return answer;
    }
}