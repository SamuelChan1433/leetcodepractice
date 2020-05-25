package com.akira.leetcodepractice.problems;

import java.util.Arrays;

/**
 * 题目：LeetCode 1046 最后一块石头的重量
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        return getLastStone(stones, stones.length);
    }

    private int getLastStone(int[] stones, int length) {
        if (length == 1) {
            return stones[0];
        } else if (length == 0) {
            return 0;
        }

        Arrays.sort(stones, 0, length);

        stones[length - 2] = stones[length - 1] - stones[length - 2];
        if (stones[length - 2] == 0) {
            length -= 2;
        } else {
            length -= 1;
        }


        return getLastStone(stones, length);
    }
}
