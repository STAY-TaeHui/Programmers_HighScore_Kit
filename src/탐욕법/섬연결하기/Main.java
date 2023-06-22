package 탐욕법.섬연결하기;

//https://school.programmers.co.kr/learn/courses/30/lessons/42861
public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n, int[][] costs) {
        /*  0 1 2 3
        * 0 0 1 2 0
        * 1 1 0 5 1
        * 2 2 5 0 8
        * 3 0 1 8 0
        *
        * 0 -> 1 -> 2 -> 3 = 1+5+8
        *   -> 2 -> 1 -> 3 = 2+5+1
        *   -> 2 -> 3 -> 1 = 2+5+1
        * 1 -> 0 -> 2 -> 3 = 1+2+8
        *   -> 2 ->
        *
        * */
//        0-
//        [[0,1,1]
//        ,[1,3,1]
//        ,[0,2,2]
//        ,[1,2,5]
//        ,[2,3,8]]
        int answer = 0;

        return answer;
    }
}