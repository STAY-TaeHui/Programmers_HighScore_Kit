package 힙.더맵게;

import java.util.*;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42626
public class Main
{
    public static void main(String[] args)
    {
//[1, 2, 3, 9, 10, 12]	7	2
        Solution.solution(new int[] {1,2,3,9,10,12},7);
//        Solution.solution(new int[] {1,1,2,6},24);

    }
}
class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> priorQueue = Arrays.stream(scoville)
            .boxed()
            .collect(Collectors.toCollection(PriorityQueue::new));

        while(priorQueue.size()>1){
            if (priorQueue.peek() >= K)
            {
                return answer;
            }else{
                priorQueue.add(priorQueue.remove() + priorQueue.remove()*2);
                answer++;
            }
            if (priorQueue.size() == 1 && priorQueue.peek() < K)
            {
                return -1;
            }
        }

        //아래는 Prioity Queue 사용 전
        /*List<Integer> scoList = Arrays.stream(scoville)
            .boxed()
            .collect(Collectors.toList());

        while(scoList.size()>1){
            Collections.sort(scoList); // 오름차순으로 정렬. 이때 비용이 많이 듬.
            if(scoList.get(0)>=K){ // 0번 >= K 이면 return
                return answer;
            }else{
                scoList.set(1,scoList.get(0) + scoList.get(1)*2);// 1번에 계산한 값 넣어주고
                scoList.remove(0); //0번 제거
            }

            if(scoList.size()==1 && scoList.get(0)<K){ //이후 list size==0 이고, 0번 <K 이면 코스빌 지수 만들지 못함.
                return -1;
            }
            answer++;
        }*/

        return answer;
    }
}