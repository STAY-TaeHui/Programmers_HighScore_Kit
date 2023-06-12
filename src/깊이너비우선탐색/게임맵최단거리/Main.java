package 깊이너비우선탐색.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class Main {
    public static void main(String[] args) {
        Solution.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
    }
}
/*
[1,0,1,1,1],   0,0 =>  0,1 / 1,0 / 0,-1 / -1,0
[1,0,8,0,12],
[1,0,7,8,1],
[1,1,1,0,1],
[0,0,0,0,1]
* */
//최단거리 -> BFS 사용 (Queue)
class Solution {
    static Queue<int[]> route;
    public static int solution(int[][] maps) {
        int answer = 0;
        int[][] directionMap = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        route = new LinkedList<>();
        route.add(new int[]{0, 0});

        while(!route.isEmpty()){
            int[] curLocation = route.poll();
            int curX = curLocation[0];// 현재 X
            int curY = curLocation[1];// 현재 Y
            int count = maps[curX][curY]; // 현재 걸어온 칸 수

            for(int[] d : directionMap){ // 방향키 맵 전체 순회
                int nextX = curX+d[0]; //다음 X
                int nextY = curY+d[1]; //다음 Y

                if(nextX<0 || nextX>= maps.length || nextY<0 || nextY>= maps[0].length) //다음 x,y가 맵을 벗어났을때
                    continue;

                if(maps[nextX][nextY] == 1){ // 방문안했고, 갈수있는 방향이면
                    maps[nextX][nextY] += count; //다음은 1이기 때문에 현재 걸어온 칸수를 더해줌.
                    route.add(new int[]{nextX,nextY});// 갈수있는 경로를 Queue에 추가.
                }
            }

        }
        answer = maps[maps.length-1][maps[0].length-1]; // 도착했을 때의 칸수를 넣어줌.

        return answer ==1 ? -1 : answer;
    }
}