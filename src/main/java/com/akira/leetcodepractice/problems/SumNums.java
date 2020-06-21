package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 64 求 1+2+...+n
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class SumNums {
    public static void main(String[] args) {
        System.out.println(new SumNums().sumNums(3));
        System.out.println(new SumNums().sumNums(9));
    }

    public int sumNums(int n) {

        boolean isEnd = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
