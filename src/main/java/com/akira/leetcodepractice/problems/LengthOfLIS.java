package com.akira.leetcodepractice.problems;

import java.util.Arrays;

/**
 * 题目：LeetCode 300 最长递增子序列
 */
public class LengthOfLIS {

    public static void main(String[] args) {
        int[] test = new int[]{
                10,9,2,5,3,7,101,18
        };

        System.out.println(new LengthOfLIS().lengthOfLIS(test));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int tmpMax;
        for (int i = 0; i < nums.length; i++) {
            tmpMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmpMax = Math.max(dp[j], tmpMax);
                }
            }

            dp[i] = tmpMax + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
