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
[1,0,1,0,12],
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
            int curX = curLocation[0];
            int curY = curLocation[1];
            int count = maps[curX][curY];

            for(int[] d : directionMap){ // 방향키 맵 전체 순회
                int nextX = curX+d[0];
                int nextY = curY+d[1];

                if(nextX<0 || nextX>= maps.length || nextY<0 || nextY>= maps.length )
                    continue;

                if(maps[nextX][nextY] == 1){ // 방문안했고, 갈수있는 방향이면
                    maps[nextX][nextY] += count;
                    route.add(new int[]{nextX,nextY});// route Queue에 추가.
                }
            }

        }

        return answer;
    }
}