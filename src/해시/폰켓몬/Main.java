package 해시.폰켓몬;
//https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main
{
//    [3,3,3,2,2,4]
}
class Solution {
    public int solution(int[] nums) {
        int[] ints = Arrays.stream(nums)
            .distinct()
            .toArray();

        System.out.println(Math.min(ints.length, nums.length / 2));
        return Math.min(ints.length, nums.length / 2);
    }
}