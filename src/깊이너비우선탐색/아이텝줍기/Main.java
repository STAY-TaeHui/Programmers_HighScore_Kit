package 깊이너비우선탐색.아이텝줍기;


import java.util.LinkedList;
import java.util.Queue;

//https://school.programmers.co.kr/learn/courses/30/lessons/87694
public class Main
{
    public static void main(String[] args)
    {
        Solution.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8);
    }
}
class Solution {
    static int [][] map;
    static Queue<int[]> routeQueue;
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[101][101];
        routeQueue = new LinkedList<>();
        int[][] directionMap = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] rect : rectangle){
            fillMap(rect[0]*2, rect[1]*2,rect[2]*2,rect[3]*2);
        }

        routeQueue.add(new int[]{characterX*2,characterY*2});

        while (!routeQueue.isEmpty()) {
            int[] curLocation = routeQueue.poll();
            int x = curLocation[0];
            int y = curLocation[1];
            int count = map[x][y];

            for(int[] d : directionMap){ // 방향키 맵 전체 순회
                int nextX = x+d[0]; //다음 X
                int nextY = y+d[1]; //다음 Y

                if(nextX<0 || nextX>= map.length || nextY<0 || nextY>= map[0].length) //다음 x,y가 맵을 벗어났을때
                    continue;

                if(map[nextX][nextY] == 1){ // 방문안했고, 갈수있는 방향이면
                    map[nextX][nextY] += count; //다음은 1이기 때문에 현재 걸어온 칸수를 더해줌.
                    routeQueue.add(new int[]{nextX,nextY});// 갈수있는 경로를 Queue에 추가.
                }
            }
        }
        answer = map[itemX*2][itemY*2]/2;
        return answer;
    }

    private static void fillMap(int x1, int y1, int x2, int y2) {
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++){
                if (i == x1 || i == x2 || j == y1 || j == y2) {
                    if(map[i][j] != 2){
                        map[i][j] = 1;// 테두리
                    }
               }
                else{
                    map[i][j] = 2;// 내부
                }
            }
        }
    }
}