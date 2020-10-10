package com.akira.leetcodepractice.problems;

import com.akira.leetcodepractice.tools.PrintUtil;

/**
 * 题目：LeetCode 167 两数之和II 驶入有序数组
 */
public class TwoSum2 {
    public static void main(String[] args) {
        int[] test = new int[]{2, 7, 11, 15};
        int target = 9;

        PrintUtil.printArr(new TwoSum2().twoSum(test, target));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && numbers[i] + numbers[j] == target) {
                    res[0] = Math.min(i+1, j+1);
                    res[1] = Math.max(i+1, j+1);
                    return res;
                }
            }
        }

        return null;
    }
}
