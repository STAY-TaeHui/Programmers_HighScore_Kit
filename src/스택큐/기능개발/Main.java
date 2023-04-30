package 스택큐.기능개발;
//https://school.programmers.co.kr/learn/courses/30/lessons/42586
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Solution.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
        Solution.solution(new int[] {90, 90, 90, 90}, new int[] {30,1,1,1});

    }
}
class Solution {
    static final int COMPLETE = 100;
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> progressQueue = Arrays.stream(progresses) //progresses를 List로 만들기.
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> speedQueue = Arrays.stream(speeds)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        int time = 0; // 걸릴 시간
        int deploy = 0; // 배포 개수
        while(!progressQueue.isEmpty()){
            int pNext = progressQueue.poll();// 93 30 55
            int sNext = speedQueue.poll();// 1 30 5
            if(pNext + time*sNext>= 100){ // 현재 프로세스가 이전에 걸린시간과 계산해서 100이 넘으면 같이 배포
                deploy++;
            }else{
                if(deploy!=0){ // 새로운 배포를 하기 전에 list에 add
                    answer.add(deploy);
                }
                deploy = 0; // 새로운 배포날짜
                time = COMPLETE - pNext; // 현재 남은 프로세스 퍼센트 100 - process
                time = time % sNext != 0 ? (time/sNext)+1 : time/sNext;
                deploy++;
            }

        }
        answer.add(deploy);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}