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
        System.out.println(Solution.solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//        System.out.println(Solution.solution(5,new int[]{2,4}, new int[]{3}));
//        Solution.solution(3,new int[]{3}, new int[]{1});

//        Solution.solution(4,new int[]{1,3}, new int[]{2,4});

    }
}

class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int []left = new int[n];
        int []right = new int[n];

        fillArray(left,lost,reserve);
        fillArray(right,lost,reserve);

        for(int i=0; i<n; i++){
            if(left[i]>1){
                if(i-1>=0){
                    lend(left,i, i-1);
                }
            }
            if (right[i] > 1) {
                lend(right,i,-1);
            }
        }

        return Math.max((int)Arrays.stream(left)
                .filter(l -> l>0)
                .count(),
                (int)Arrays.stream(right)
                .filter(r -> r>0)
                .count());
    }

    private static void fillArray(int[] arr, int[] lost, int[] reserve) {
        Arrays.fill(arr,1);

        for(int l : lost){
            arr[l-1] +=-1;
        }
        for(int r : reserve){
            arr[r-1] +=1;
        }
    }
    private static void lend(int[] uniformCount, int from, int to) {
        boolean flag = false;

        if (to >= 0 && to < uniformCount.length) { // 배열 인덱스 벗어나지 않고
            if (uniformCount[to] == 0) {
                uniformCount[from] -= 1;
                uniformCount[to] += 1;
                flag = true;
            }
        }
    }
}
