package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 11 旋转数组的最小值
 */
public class MinArray {
    public int minArray(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i-1]) {
                return numbers[i];
            }
        }

        return numbers[0];
    }
}
