package com.akira.leetcodepractice.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目：LeetCode 354 俄罗斯套娃信封问题
 */
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] test = new int[][] {
                {5,4},{6,4},{6,7},{2,3}
        };

        System.out.println(new MaxEnvelopes().maxEnvelopes(test));
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, Comparator.comparingInt(o -> o[0]));

        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int tmpMax;
        for (int i = 0; i < envelopes.length; i++) {
            tmpMax = 0;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] &&
                        envelopes[i][1] > envelopes[j][1]) {
                    tmpMax = Math.max(tmpMax, dp[j]);
                }
            }

            dp[i] = tmpMax + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
