package 해시.폰켓몬;
//https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;
import java.util.stream.IntStream;

public class Main
{
//    [3,3,3,2,2,4]
}
class HashSolution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        return Math.min(set.size(), nums.length);
    }
}
//class Solution {
//    public int solution(int[] nums) {
//        int[] ints = Arrays.stream(nums)
//            .distinct()
//            .toArray();
//
//        return Math.min(ints.length, nums.length / 2);
//    }
//}