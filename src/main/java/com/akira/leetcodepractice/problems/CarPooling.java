package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 1094 拼车
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] tripInfo = new int[1001];

        for (int[] singleTrip : trips) {
            tripInfo[singleTrip[1]] += singleTrip[0];
            tripInfo[singleTrip[2]] -= singleTrip[0];
        }

        if (tripInfo[0] > capacity) {
            return false;
        }

        for (int i = 1; i < tripInfo.length; i++) {
            tripInfo[i] += tripInfo[i - 1];
            if (tripInfo[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}
