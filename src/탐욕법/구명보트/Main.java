package 탐욕법.구명보트;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);// 정렬
        int count=0;
        for(int i=0, j= people.length-1; i<=j;){
            if(people[i]+people[j] >limit){//가장 가벼운사람과 무거운사람 둘 다 탈때, 무게 초과이면
                count++;
                j--;// 무거운사람만 태움
            }
            else{//가장 가벼운 사람과 가장 무거운사람을 같이 태움
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        return count;
    }
}