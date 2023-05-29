package 깊이너비우선탐색.네트워크;

//https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class Main {
    public static void main(String[] args) {
//        Solution.solution(5, new int[][]{{1,0,1,1,0},{},{},{},{}});
        Solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
}
/*
* 　　１　２　３　４
* １　１　０　２　０
* ２　０　１　２　２
* ３　２　２　１　０
* ４　０　２　０　１
* */
class Solution {
    static boolean[] check;
    static int answer = 0;
    public static int solution(int n, int[][] computers) {
        //이번 문제는 노드와 연결되어있는 노드들을 모두 찾아 방문표시를 해두고,
        //방문하지 않은 노드들부터 다시 시작해준다.
        //이전 문제들과 다른점은 방문 했던 노드들에 재방문 하지 않는다는 점이다.
        check  = new boolean[n];

        for(int i=0; i<computers.length; i++){ //전체 노드 순회
            if(!check[i]) {// 노드 방문 체크
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs( int curNode, int[][] computers){
            check[curNode] = true;
            for (int i = 0; i < computers[curNode].length; i++) { // 해당 노드와 연결되어있는 노드 순회
                if (curNode != i) { // 자기 자신 노드는 제외
                    if (computers[curNode][i] == 1 && !check[i]) { //해당 노드와 연결되어있고 방문한 적이 없다면 실행
                         dfs(i, computers);
                    }
                }
        }
    }
}