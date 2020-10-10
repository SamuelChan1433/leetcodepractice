package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 392 是否为子序列
 */
public class Subsequence {

    /**
     * 判断s是否为t的子序列
     *
     * @param s 子序列
     * @param t 原字符串
     * @return 是为true
     */
    public boolean isSubsequence(String s, String t) {

        int i = 0;
        int k = -1;
        int hitCount = 0;
        for (; i < s.length(); i++) {
            while (k < t.length() - 1) {
                k++;
                if (t.charAt(k) == s.charAt(i)) {
                    hitCount++;
                    break;
                }
            }
        }

        return hitCount == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "axbxc";

        System.out.println(new Subsequence().isSubsequence(s, t));
    }
}
