package 스택큐.다리를지나는트럭;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//https://school.programmers.co.kr/learn/courses/30/lessons/42583?language=java

public class Main {
    public static void main(String[] args) {
        Solution.solution(10,10,new int[]{1,10,1,10,10});
    }
}
/*
0 [] [] 10 0
1 [] [1] 0 1
2 [] [1,0] 456 7
3 [7] [1,0,0] 56 0
11 [1] [0]

* */
class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time=0;
        int index=0;
        int total_weight=0;
        Queue<Integer> bridgeQ = new LinkedList<>(); //다리
        //offer -> 값 추가     poll -> 값 반환 및 제거
        do{
            time++;

            if(bridgeQ.size()==bridge_length){ // 다리가 꽉차있으면 빼주기
                total_weight -= bridgeQ.poll();
            }
            if(total_weight + truck_weights[index] <= weight){ // 다리에 올라갈 수 있을때
                bridgeQ.offer(truck_weights[index]);
                total_weight += truck_weights[index];
                index++;
            }
            else{
                bridgeQ.offer(0);// 다리에 못올라 갈때
            }
        }while(index<truck_weights.length);

        if(time< bridge_length){// 다리 길이보다 걸린시간이 작으면
            time+= bridge_length-time; // 다리 다 지나갈 만큼 시간 더해주기
        }
        return time + bridgeQ.size(); // 남은 queue 만큼 시간 더해주기
    }
}