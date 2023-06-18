package 탐욕법.조이스틱;

//https://school.programmers.co.kr/learn/courses/30/lessons/42860
public class Main {
    public static void main(String[] args) {
        Solution.solution("JEROEN");
    }
}
class Solution {
    public static int solution(String name) {
        int answer = 0;
        int minWay = name.length()-1;

        for(int i=0 ; i<name.length(); i++){
            char now = name.charAt(i);
            if(now!='A'){
                answer+=Math.min(now-'A', 'Z'-now+1);
            }
            int next=i+1;
            // i 다음 문자가 A로 시작한다면 A가 끝나는 위치 찾기
            while(next<name.length() && name.charAt(next)=='A') next++;
            minWay=Math.min(minWay, i+i+name.length()-next);
        }
        System.out.println(answer+minWay);
        return answer+minWay;
    }
}