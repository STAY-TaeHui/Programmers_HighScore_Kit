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
            treeWires.get(w[0]).add(w[1]);
            treeWires.get(w[1]).add(w[0]);
        }

        //wires를 전체 순환 하면서 모든 원소를 제거 해 보면서 체크
        for(int w=0; w<=wires.length/2; w++){
            cutWires(treeWires, wires[w][0], wires[w][1]);
            int answer = n;
            for(int i=1; i<treeWires.size(); i++){
                if(!check[i]) {
                    answer = dfs(i, treeWires);
                    answer = Math.abs(answer);
                    answerList.add(answer);
                }

            }
            recoverWires(treeWires,wires[w][0], wires[w][1]);
        }
        return answerList.stream().min(Integer::compareTo).get();
    }
    public static int dfs(int next ,List<List<Integer>> treeWires){
        return dfs(next, treeWires, 1);
    }
    public static int dfs(int next ,List<List<Integer>> treeWires, int count){

        if(!check[next]){
            check[next] = true;
            for(Integer node : treeWires.get(next)){
                count = dfs(node, treeWires, count+1);
            }
        }else count-=1;
        return count;
    }
    public static void cutWires(List<List<Integer>> treeWires, int v1, int v2){// 전선 제거 //1,2
        treeWires.get(v1).remove((Integer) v2);
        treeWires.get(v2).remove((Integer)v1);
    }
    public static void recoverWires(List<List<Integer>> treeWires, int v1, int v2){// 전선 연결
        treeWires.get(v1).add(v2);
        treeWires.get(v2).add(v1);
        check = new boolean[treeWires.size()];
    }
}