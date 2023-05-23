package 완전탐색.전력망;

import java.util.ArrayList;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/86971
public class Main
{
    public static void main(String[] args)
    {
        Solution.solution(7, new int[][] {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}});
    }
}

class Solution {
    public static boolean [] check;
    public static int solution(int n, int[][] wires) {
        check = new boolean[n+1]; //0번은 비우기
        List<Integer> answerList = new ArrayList<>(); //정답체크
        List<List<Integer>> treeWires = new ArrayList<>();

        for(int i=0; i<=n; i++){ //0~7까지
            treeWires.add(new ArrayList<Integer>()); // 2차원 리스트 생성
        }

        for(int[] w : wires){
            treeWires.get(w[0]).add(w[1]); //w[0] 인덱스에 w[1]을 넣어줌 // [7] - {2,3,6}
            treeWires.get(w[1]).add(w[0]); //w[1] 인덱스에 w[0]을 넣어줌 // [3] - {7}
        }

        //wires를 전체 순환 하면서 모든 원소를 제거 해 보면서 체크
        for(int w=0; w<wires.length; w++){
            cutWires(treeWires, wires[w][0], wires[w][1]);// 전선 자르기

            int answer = dfs(1, treeWires, 1);// 결과값 : 1부터 연결된 개수
            answer = Math.abs(answer - (n-answer)); // n-answer : 전력망이 두개로 나눠지기 때문에 1부터 연결된 개수의 반대 개수
            answerList.add(answer);// 해당 결과를 List에 넣어줌

            recoverWires(treeWires,wires[w][0], wires[w][1]);// 전선 다시 연결
        }
        return answerList.stream().min(Integer::compareTo).get();
    }
    /*
    * next : 다음노드
    * treeWires : 전령망
    * count : 거쳐간 노드 개수
    */
    public static int dfs(int next ,List<List<Integer>> treeWires, int count){
        if(!check[next]){ // 방문 체크
            check[next] = true; //방문 완료
            for(Integer node : treeWires.get(next)){ //다음 노드와 연결되어있는 모든 노드 순회
                count = dfs(node, treeWires, count+1);// count 올리고 호출
            }
        }else count-=1;// 이미 방문했던 노드라면 count--;
        return count;// 지금까지 방문한 count 리턴
    }
    public static void cutWires(List<List<Integer>> treeWires, int v1, int v2){// 전선 제거 // 3,7
        treeWires.get(v1).remove((Integer) v2);// [3] - {7}만 제거
        treeWires.get(v2).remove((Integer)v1);// [7] - {3}만 제거
    }
    public static void recoverWires(List<List<Integer>> treeWires, int v1, int v2){// 전선 연결 // 3,7
        treeWires.get(v1).add(v2);// [3] - {7}만 추가
        treeWires.get(v2).add(v1);// [7] - {3}만 추가
        check = new boolean[treeWires.size()];// check 초기화
    }
}