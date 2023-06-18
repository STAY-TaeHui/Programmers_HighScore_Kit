package 탐욕법.체육복;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/42862
/*
* 그리디 첫번째 문제.
* 그리디(Greedy, 탐욕법) 문제는 완전탐색 알고리즘이 너무 오래걸린다는 단점을 보완하기 위해 나온
* 다이나믹프로그래밍(DP)와 유사하지만 좀더 빠른 알고리즘이다.
* DP또한 최적해를 구하고자 완전탐색에 가까운 시간이 걸리기 때문에 탐욕법으로 시간을 더 줄인다.
* */
public class Main {
    public static void main(String[] args) {
//        System.out.println(Solution.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//        System.out.println(Solution.solution(5,new int[]{2,4}, new int[]{3}));
        Solution.solution(3,new int[]{3}, new int[]{1});

//        Solution.solution(4,new int[]{1,3}, new int[]{2,4});

    }
}

class Solution {
    static boolean []check;
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        check = new boolean[n+1];


        Arrays.sort(lost);
        Arrays.sort(reserve);

        //같은 학생 걸르기
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){
                    if(!check[lost[i]]){
                        check[lost[i]] = true;
                        answer++;

                    }
                }
            }
        }
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                    if(reserve[j]-1 == lost[i]){
                        if(!check[reserve[j]] && !check[lost[i]]) {
                            check[reserve[j]]=true;
                            check[lost[i]]=true;
                            answer++;
                        }

                    }else if(reserve[j]+1 == lost[i]){
                        if(!check[reserve[j]] && !check[lost[i]]) {
                            check[reserve[j]]=true;
                            check[lost[i]]=true;
                            answer++;
                        }
                    }
            }
        }
        return answer;

    }
}