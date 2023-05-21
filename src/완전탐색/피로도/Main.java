package 완전탐색.피로도;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java
public class Main
{
    public static void main(String[] args)
    {
//        Solution.solution(40, new int[][]{{40,20},{10,10}});
        Solution.solution(80, new int[][]{{80,20},{50,40},{30,10}});
    }
}

class Solution {
    public static boolean[] check; // 방문했는지 체크 할 배열
    public static int answer=0;
    public static int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        System.out.println(answer);
        return answer;
    }
    /*
    dep : 재귀의 깊이. dungeons[].length() 까지 들어갈 수 있음. --> "던전 방문 횟수"와 같다.
    fatigue : 현재 피로도
    dungeons : 던전 배열
    * */
    public static void dfs(int dep, int fatigue, int[][] dungeons){
        if(dep == dungeons.length+1){ //던전을 끝까지 돌았을때. dep은 던전의 배열크기보다 1 크다.
            System.out.println(dep + "   " + fatigue);
            return ;
        }
        else if(fatigue<=0){ // 피로도가 0일때, 다른 던전 못가기 때문에 끝
            System.out.println(dep + "   " + fatigue);
            return ;

        }

        for(int i=0; i< dungeons.length; i++){ //던전 개수만큼 반복
            if(!check[i]){// 현재 index(던전)에 방문한적이 없을 때
                int[] dungeon = dungeons[i];// 해당 던전
                if(fatigue>=dungeon[0]){//최소 피로도 조건
                    check[i] = true; //방문 체크
                    fatigue = fatigue-dungeon[1]; //피로도 깍아주고
                    answer = Math.max(answer,dep); //현재 던전 방문 횟수와 answer와 Max
                    dfs(dep+1, fatigue, dungeons); //처음에 던전 하나 방문하고 다음 던전으로 넘어가기 떄문에,
                                                        //방문한 던전 횟수를 넘겨준다.

                    check[i] = false; //던전 방문 끝
                    fatigue = fatigue+dungeon[1];// 다시 피로도 올려줌. -> 방문 안했다는 표시

                }
            }
        }
        answer = Math.max(answer,dep);

    }
}