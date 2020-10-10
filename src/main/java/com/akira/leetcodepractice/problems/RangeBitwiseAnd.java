package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 201 数字范围按位与
 */
public class RangeBitwiseAnd {
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        System.out.println("result = " + new RangeBitwiseAnd().rangeBitwiseAnd(m, n));

        m = 1;
        n = 2147483647;
        long t = System.currentTimeMillis();
        System.out.println("result = " + new RangeBitwiseAnd().rangeBitwiseAnd(m, n));
        System.out.println(System.currentTimeMillis() - t + "ms");
    }

    public int rangeBitwiseAnd(int m, int n) {
        int result = n;
        for (int k = m; k < n; k++) {
            result = result & k;
            if (result == 0) {
                return 0;
            }
        }

        return result;
    }
}
