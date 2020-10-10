package com.akira.leetcodepractice.problems;

import com.sun.org.apache.regexp.internal.RESyntaxException;

/**
 * 题目：LeetCode 43 字符串相乘
 */
public class Multiply {

    public static void main(String[] args) {
        String n1 = "237";
        String n2 = "284";
        // 67308
        System.out.println(new Multiply().multiply(n1, n2));

        n1 = "9";
        n2 = "99";
        // 891
        System.out.println(new Multiply().multiply(n1, n2));

        n1 = "999";
        n2 = "999";
        // 998001
        System.out.println(new Multiply().multiply(n1, n2));

        n1 = "11";
        n2 = "11";
        System.out.println(new Multiply().multiply(n1, n2));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[][] progress = new int[110][110];
        int n1Offset = 0;
        int maxN1 = 0;
        int n2Offset = 0;

        int adder = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            n1Offset = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int m = getMultiplyOfStr(num1.charAt(j), num2.charAt(i));
                progress[n1Offset][n2Offset] = m % 10 + adder;
                adder = m / 10;
                n1Offset++;
            }
            progress[n1Offset][n2Offset] = adder;
            adder = 0;
            n2Offset++;
            maxN1 = Math.max(maxN1, n1Offset);
        }
        n1Offset = maxN1 + 1;

        StringBuilder result = new StringBuilder();
        adder = 0;
        for (int i = 0; i < n1Offset; i++) {
            int res = 0;
            int i1 = i;
            int j1 = 0;
            while (i1 >= 0 && j1 <= n2Offset) {
                res += (progress[i1--][j1++]);
            }
            res += adder;
            result.append(res%10);
            adder = res/10;
        }

        for (int j = 1; j <= n2Offset; j++) {
            int res = 0;
            int i1 = n1Offset-1;
            int j1 = j;
            while (i1 >= 0 && j1 <= n2Offset) {
                res += (progress[i1--][j1++]);
            }
            res += adder;
            result.append(res%10);
            adder = res/10;
        }

        result.append(adder);
        String raw = result.reverse().toString();
        int pos = 0;
        for (int i = 0; i < raw.length(); i++) {
            if (raw.charAt(i) == '0') {
                pos++;
            } else {
                break;
            }
        }
        return raw.substring(pos);
    }

    private int getMultiplyOfStr(char charA, char charB) {
        return (charA - '0') * (charB - '0');
    }
}
