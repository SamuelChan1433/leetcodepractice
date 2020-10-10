/*
 * 题目：LeetCode
 */

package com.akira.leetcodepractice.problems;

public class MaxCoins {

    public static void main(String[] args) {
        int[] test = new int[]{3, 1, 5, 8}; // 167
        System.out.println(new MaxCoins().maxCoins(test));
    }

    int[] val;
    int[][] result;

    public int maxCoins(int[] nums) {
        int size = nums.length;
        val = new int[size + 2];
        val[0] = 1;
        val[size+1] = 1;
        result = new int[val.length][val.length];
        System.arraycopy(nums, 0, val, 1, size);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = -1;
            }
        }

        return solve(0, size+1);
    }

    private int solve(int left, int right) {
        if (left+1 >= right) {
            return 0;
        }

        if (result[left][right] != -1) {
            return result[left][right];
        }

        int v;
        for (int i = left+1; i < right; i++) {
            v = val[left] * val[i] * val[right];
            v = v + solve(left, i) + solve(i, right);
            result[left][right] = Math.max(result[left][right], v);
        }

        return result[left][right];
    }
}
