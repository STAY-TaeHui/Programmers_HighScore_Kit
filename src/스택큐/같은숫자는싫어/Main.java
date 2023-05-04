package 스택큐.같은숫자는싫어;

import java.util.*;
import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
        Solution.solution(new int[] {1,2,3,4,4,2,3,3});
    }
}
class Solution
{
    public static int[] solution(int[] arr)
    {
        Stack<Integer> st = new Stack<>(); //Stack 사용

        for(int v : arr){
            if(st.isEmpty()){ //스택 비어있으면 처음 값
//                st.add(v); add는 return boolean;
                st.push(v); // push는 return v;
            }else{
                if(st.peek() != v){// 스택 맨 위 뽑아서 넣어줄 값이랑 비교
                    st.push(v);
                }
            }
        }
        int[] ints = st.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        return ints;
    }
}