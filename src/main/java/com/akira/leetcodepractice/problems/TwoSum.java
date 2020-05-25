package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 1 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int a;
        int b;
        int sum;
        int[] result = new int[2];

        if (nums == null || nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                a = nums[i];
                b = nums[j];
                sum = a + b;
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return null;
    }
}
