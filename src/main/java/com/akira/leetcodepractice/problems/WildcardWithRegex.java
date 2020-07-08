package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 10 正则表达式匹配
 */
public class WildcardWithRegex {
    public static void main(String[] args) {
        testCase("aaa", "ab*a*c*a"); // true
        testCase("aa", "a*"); // true
        testCase("ab", ".*"); // true
        testCase("aab", "c*a*b"); // true
        testCase("mississippi", "mis*is*p*."); // false

        testCase("a", "ab*a*c*"); // true
    }

    private static void testCase(String s, String p) {
        System.out.println("is match : " + new WildcardWithRegex().isMatch(s, p));
    }

    private static void printA(boolean[][] dp) {
        Wildcard.printArr(dp);
    }

    public boolean isMatch(String s, String p) {
        int sSize = s.length();
        int pSize = p.length();
        boolean[][] dp = new boolean[sSize + 1][pSize + 1];

        // 初始化
        dp[0][0] = true;
        for (int j = 1; j <= pSize; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else if (j < pSize && p.charAt(j) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int j = 1; j <= pSize; j++) {
            for (int i = 1; i <= sSize; i++) {
                if (p.charAt(j - 1) == '*') {
                   if (matchChar(s.charAt(i-1), p.charAt(j-2))) {
                       dp[i][j] = dp[i-1][j] || dp[i][j-2];
                   } else {
                       dp[i][j] = dp[i][j-2];
                   }
                } else {
                    dp[i][j] = matchChar(s.charAt(i-1), p.charAt(j-1)) && dp[i - 1][j - 1];
                }
            }
        }

        //printA(dp);
        return dp[sSize][pSize];
    }

    private boolean matchChar(char s, char p) {
        return s == p || p == '.';
    }
}
