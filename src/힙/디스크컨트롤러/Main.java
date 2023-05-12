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
//        Solution.solution(new int[][]{ {1, 2}, {2, 7}, {0, 5}, {3, 3}});
        Solution.solution(new int[][]{ {0,3}, {1,9}, {2,6}});
    }
}
/*
* 0초 - 5
* */
class Solution {
    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1,o2)->o1[0]-o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int totalEndTime = 0; //총 요청~종료 시간 합계
        int endTime =0; // 이전 작업 끝난 시간
        int job =0; //작업 횟수
        int i = 0; // index

        while(job< jobs.length){ // 총 작업 횟수만큼 반복
            while(i<jobs.length && jobs[i][0] <= endTime){ //
                pq.add(jobs[i++]);
            }

            if(pq.isEmpty()){
                endTime = jobs[i][0];
            }
            else{
                int[] nextJob = pq.remove();
                totalEndTime += endTime +  nextJob[1] - nextJob[0];
                endTime += nextJob[1];
                job++;
            }
        }

        return totalEndTime/ jobs.length;
    }
}