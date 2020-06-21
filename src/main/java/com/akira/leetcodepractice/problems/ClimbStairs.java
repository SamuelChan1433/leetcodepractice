package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 70 爬楼梯
 * 动态规划
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int test1 = 2;
        int test2 = 3;
        int test3 = 5;
        int test4 = 1000;
        System.out.println(new ClimbStairs().climbStairs(test1));
        System.out.println(new ClimbStairs().climbStairs(test2));
        System.out.println(new ClimbStairs().climbStairs(test3));
        System.out.println(new ClimbStairs().climbStairs(test4));
    }

    private static final int MAX_SIZE = 1000;

    public int climbStairs(int n) {
        if (n > MAX_SIZE) {
            return -1;
        }

        int[] stairs = new int[n + 1];
        for (int i = 0; i < stairs.length; i++) {
            setStairs(stairs, i);
        }

        return stairs[n];
    }

    public void setStairs(int[] stairs, int n) {
        if (n < 4) {
            stairs[n] = n;
        } else {
            stairs[n] = stairs[n - 1] + stairs[n - 2];
        }
    }
}
