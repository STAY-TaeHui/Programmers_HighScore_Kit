package 탐욕법.조이스틱;

//https://school.programmers.co.kr/learn/courses/30/lessons/42860
public class Main {
    public static void main(String[] args) {
//        Solution.solution("JEROEN");
//        Solution.solution("ABABAAAAAAABA");//lecn=13 lastB=11
        Solution.solution("ABABAAABAAABA");
    }
}
class Solution {
    public static int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length()-1;

        for(int i=0;i<name.length();i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i+1;
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            move = Math.min(move, i*2+name.length()-index);
            move = Math.min(move, (name.length()-index)*2 + i);
        }
        return answer + move;
        /*int answer = 0;
        int right = 0;
        int len = name.length();
        int left =len-1;


        for(int i=0 ; i<len; i++){
            char now = name.charAt(i);
            if(now!='A'){
                answer+=Math.min(now-'A', 'Z'-now+1);
                right=i;
            }
//            ABABAAAAAAABA
//            ABABAAABAAABA
            int next = i+1;
            while(next<len && name.charAt(next)=='A')
                next++;
            left = Math.min(left, i*2+len-next);
            left = Math.min(left, (len-next)*2 + i);
        }
//        System.out.println(answer+minWay);
        return answer;*/
    }
}