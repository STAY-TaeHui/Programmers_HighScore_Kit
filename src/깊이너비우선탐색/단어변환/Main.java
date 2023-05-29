package 깊이너비우선탐색.단어변환;
//https://school.programmers.co.kr/learn/courses/30/lessons/43163
public class Main
{
    public static void main(String[] args)
    {
        Solution.solution("hit", "cog", new String[]{ "dot", "log", "cog", "dog", "lot","hot"});
    }
}
class Solution {
    static boolean check[];
    static int answer = Integer.MAX_VALUE;

    public static int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        dfs(0, begin, words, target);

        return answer > words.length ? 0 : answer; // 처음 세팅한 max 그대로면 0으로
    }
    public static void dfs(int depth, String str, String[] words, String target){
        if (str.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }
        for(int i=0; i<words.length; i++){ //words 전체 순회
            if(!check[i]){ // i 번째를 방문하지 않았을 때,
                char[] strChars = str.toCharArray();
                char[] wordChars = words[i].toCharArray();
                int count = 0; // char 비교했을 때 다른 개수

                for(int s=0; s<str.length(); s++){
                    if(strChars[s] != wordChars[s]){
                        count++;
                    }
                    if(count>1) break; //다른 char가 1보다 크면 바로 종료
                }
                if(count==1){
                    check[i] = true;
                    dfs(depth+1, words[i], words, target);
                    check[i] = false;
                }
            }
        }
    }
}