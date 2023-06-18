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
//        Solution.solution(3,new int[]{3}, new int[]{1});
        Solution.solution(5,new int[]{1,2,3}, new int[]{2,3,4});

//        Solution.solution(4,new int[]{1,3}, new int[]{2,4});

    }
}

class Solution {
    static boolean []check;
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer=0;
        int [] student = new int[n+2]; // int배열은 0으로 초기화됨.

        for(int l : lost){// 분실한 학생은 -1
            student[l] -=1;
        }
        for(int r : reserve){// 여벌이 있는 학생은 +1
            student[r] +=1;
        }
        //본인 체육복이 있는 학생은 0

        for(int i=1; i<student.length-1; i++){
            if(student[i] == 1){// 여벌이 있는 학생이면
                if (student[i-1] == -1) {//이전 학생이 분실했다면?
                    student[i] -=1; //본인꺼 하나 빼기
                    student[i-1] +=1;//이전 학생에게 주기
                }else if(student[i+1] == -1){//다음 학생이 분실했다면?
                    student[i] -=1;// 본인꺼 하나 빼기
                    student[i+1] +=1;//다음 학색에게 주기
                }
            }
        }
        for(int i=1; i<student.length-1; i++) {
            if(student[i] >=0){
                answer++;
            }
        }
//        return answer;
            return (int)Arrays.stream(student).filter(s -> s>=0).count()-2;// 분실한 학생 제외 count

        /*int answer = n-lost.length;//전체에서 분실한 학생 제외
        check = new boolean[n+1];//체육복 주고 받았는지

        //왜 정렬하는지 모르겠음.
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여벌을 갖고있는 학생이 분실했을 때 처리
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){//
                    if(!check[lost[i]]){
                        check[lost[i]] = true;
                        answer++;// 체육복 하나는 남아있으니 수업참여 가능

                    }
                }
            }
        }
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                    if(reserve[j]-1 == lost[i]){// 이전 학생이 분실했을 때
                        if(!check[reserve[j]] && !check[lost[i]]) {// 둘다 체육복 주고받지 않았고
                            check[reserve[j]]=true;
                            check[lost[i]]=true;
                            answer++;
                        }

                    }else if(reserve[j]+1 == lost[i]){// 다음 학생이 분실했을 때
                        if(!check[reserve[j]] && !check[lost[i]]) {// 둘다 체육복 주고받지 않았고
                            check[reserve[j]]=true;
                            check[lost[i]]=true;
                            answer++;
                        }
                    }
            }
        }
        return answer;*/

    }
}