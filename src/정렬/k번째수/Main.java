package 정렬.k번째수;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=java
public class Main
{
    public static void main(String[] args)
    {
        Solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}});
    }
}
class Solution{
    public static int[] solution(int[] array, int[][] commands) {
        int i,j,k;
        int[] answer = new int[commands.length];
        int index=0;

        for(int [] cmd : commands){
            i=cmd[0]-1;
            j=cmd[1]-1;
            k=cmd[2]-1;

            int[] tmp = Arrays.copyOfRange(array, i,j+1);
            Arrays.sort(tmp);

            answer[index++]=tmp[k];
        }
        return answer;
    }
}