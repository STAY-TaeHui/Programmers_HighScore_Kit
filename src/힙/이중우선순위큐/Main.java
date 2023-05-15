package 힙.이중우선순위큐;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java
public class Main
{
    public static void main(String[] args)
    {
        Solution.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
    }
}
class Solution {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
        Queue<Integer> minQueue = new PriorityQueue<>(); // 오름차순

        for(String o : operations){
            StringTokenizer st = new StringTokenizer(o, " "); // " " 기준으로 나눔
            String cmd = st.nextToken();
            Integer num = Integer.valueOf(st.nextToken());

            if("I".equals(cmd)){
                maxQueue.add(num); // 최대 우선에 add
                minQueue.add(num); // 최소 우선에 add
            }
            else if("D".equals(cmd)){
                if(maxQueue.isEmpty()){ // 큐가 비어있으면 무시
                    continue;
                }
                if (num == -1) { // 최소 삭제
                    commandD(minQueue, maxQueue);

                }
                else if(num == 1){// 최대 삭제
                    commandD(maxQueue, minQueue);
                }
            }
        }

        answer[0] = maxQueue.peek() == null ? 0 : maxQueue.poll();
        answer[1] = minQueue.peek() == null ? 0 : minQueue.poll();

        return answer;
    }
    public static void commandD(Queue<Integer> m1, Queue<Integer> m2){
        m1.remove(); //큐에서 하나 삭제
        m2.clear(); // 다른 큐 비우기
        m2.addAll(m1); // 비어있는 큐에 하나 지워준 큐 복사
    }
}