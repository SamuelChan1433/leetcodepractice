package com.akira.leetcodepractice.problems;

import java.util.Arrays;

/**
 * 题目：LeetCode 16.11 跳水板
 */
public class DivingBoard {
    public static void main(String[] args) {
        int shorter = 1;
        int longer = 2;
        int k = 4;
        /*int shorter = 7;
        int longer = 3625;
        int k = 19808;*/

        System.out.println(Arrays.toString(new DivingBoard().divingBoard(shorter, longer, k)));
    }

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter*k};
        }
        int[] res = new int[k+1];
        for (int i = 0; i <= k; i++) {
            res[i] = shorter*(k-i) + longer*(i);
        }
        return res;
    }
}
