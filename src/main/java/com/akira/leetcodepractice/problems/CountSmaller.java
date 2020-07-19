/*
 * 题目：LeetCode
 */

package com.akira.leetcodepractice.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


// 超时
public class CountSmaller {
    public static void main(String[] args) {
         int[] test = new int[] {5, 2, 6, 1};
        //int[] test = new int[] {5, 5};
        List<Integer> result = new CountSmaller().countSmaller(test);
        result.forEach(System.out::println);
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] result = new int[nums.length];
        LinkedList<Integer> reversedArr = new LinkedList<>();
        for (int i = nums.length-1; i >=0; i--) {
            int index = insertList(reversedArr, nums[i]);
            result[i] = index;
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private int insertList(LinkedList<Integer> reversedArr, int num) {
        if (reversedArr.size() == 0) {
            reversedArr.add(num);
            return 0;
        }
        for (int i = 0; i < reversedArr.size(); i++) {
            if (num <= reversedArr.get(i)) {
                reversedArr.add(i, num);
                return i;
            }
        }

        reversedArr.add(num);
        return reversedArr.size()-1;
    }
}
