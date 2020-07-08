package com.akira.leetcodepractice.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 题目：LeetCode 44 通配符匹配
 * 动态规划
 */
public class Wildcard {
    public static void main(String[] args) {
        testCase("aa", "a"); // false
        testCase("aa", "*"); // true
        testCase("cb", "?a"); // false
        testCase("adceb", "*a*b"); // true
        testCase("acdcb", "a*c?b"); // false
    }

    private static void testCase(String s, String p) {
        System.out.println("is match : " + new Wildcard().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int sSize = s.length();
        int pSize = p.length();
        boolean[][] dp = new boolean[sSize + 1][pSize + 1];
        dp[0][0] = true;

        // 初始化：s为空时，p仅含*时为true
        for (int j = 1; j <= pSize; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int j = 1; j <= pSize; j++) {
            for (int i = 1; i <= sSize; i++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 仅含小写字母时
                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
                }
            }
        }

        return dp[sSize][pSize];
    }

    public static void printArr(boolean[][] dp) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                stringBuilder.append(dp[i][j]).append(" ");
            }

            stringBuilder.append(System.lineSeparator());
        }

        System.out.println(stringBuilder.toString());
    }


    // 超出时间限制
    private boolean isMatch_time_exceed(String s, String p) {
        if (s == null || s.length() == 0) {
            return p == null || p.length() == 0 || p.equals("*");
        }

        String regex = p.replaceAll("\\*", ".*")
                .replaceAll("\\?", ".{1}");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }
}
