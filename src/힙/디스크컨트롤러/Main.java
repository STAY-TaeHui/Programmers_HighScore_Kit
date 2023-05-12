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
/*
* 0초 - 5
* */
class Solution {
    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs);

        PriorityQueue<int[]> pq = new PriorityQueue<>((c1, c2)-> (c1[1]-c2[1]));
        pq.add(jobs[0]);// 0초에 바로 넣기

        int time = 0; //총 걸린 시간
        int endTime = 0;

        for(int i=0; i< jobs.length; i++){
            while(!pq.isEmpty()){
                int[] nextJob = pq.remove();
                time +=nextJob[1];
                endTime +=nextJob[1];
            }



        }



        return answer;
    }
}