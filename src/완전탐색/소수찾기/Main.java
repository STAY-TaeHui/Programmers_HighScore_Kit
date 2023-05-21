package 완전탐색.소수찾기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java
public class Main
{
    public static void main(String[] args)
    {
        Solution.solution("1231");
    }
}
class Solution {
    public static Set<Integer> set = new HashSet<>(); //중복 방지를 위한 Set
    public static boolean[] check; //DFS에서 해당 index를 방문했는지 체크하기 위한 배열

    public static int solution(String numbers) {
        check = new boolean[numbers.length()];
        StringBuilder sb = new StringBuilder();

        dfs(0, sb, numbers);

        return set.size();
    }

    // dep : 재귀가 몇번에 중첩인지
    // sb : 재귀에서 문자열을 붙이고 빼기 위한 StringBuilder
    // str : solution()에서 파라미터로 들어온 numbers
    public static void dfs(int dep, StringBuilder sb, String str){
        if(dep == str.length()){ // 재귀가 마지막까지 들어갔기때문에 바로 return 해줌
            return;
        }
        for(int i=0; i< str.length(); i++){ //str 길이만큼 반복문 돌면서 str을 처음부터 끝까지 순회함.
            if(!check[i]){// 방문하지 않은 index라면
                sb.append(str.charAt(i)); //sb에 str의 해당 인덱스 char 추가

                prime(sb.toString()); //소수인지 체크

                check[i] = true; //해당 index를 방문했다고 check
                dfs(dep+1, sb, str);// dep+1 해서 재귀

                check[i] = false;// 재귀가 끝나면 해당 index의 방문을 해제하고,
                sb.deleteCharAt(sb.length()-1);//sb에서 마지막 문자를 삭제해줌.
            }
        }
    }
    public static void prime(String num){
        int n = Integer.parseInt(num);
        if(n<2){
            return;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return;
            }
        }
        set.add(n);
    }
}
