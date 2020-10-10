package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 67 字符串转数字
 */
public class StrToInt {

    public static void main(String[] args) {
        String t1 = "42";
        System.out.println(new StrToInt().strToInt(t1));

        String t2 = "      -42";
        System.out.println(new StrToInt().strToInt(t2));

        String t3 = "4193 with words";
        System.out.println(new StrToInt().strToInt(t3));

        String t4 = "words and 987";
        System.out.println(new StrToInt().strToInt(t4));

        String t5 = "-91283472332";
        System.out.println(new StrToInt().strToInt(t5));

        String t6 = "  +1m7and 9";
        System.out.println(new StrToInt().strToInt(t6));

        String t7 = "   +0 1234";
        System.out.println(new StrToInt().strToInt(t7));
    }

    public int strToInt(String str) {
        int start = -1;
        int length = 0;

        for (int i = 0; i < str.length(); i++) {
            if (start != -1) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    break;
                }
            }

            if (str.charAt(i) != ' ') {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9' || str.charAt(i) == '-' || str.charAt(i) == '+') {
                    length++;
                    if (start == -1) {
                        start = i;
                    }
                } else {
                    break;
                }
            }
        }

        if (start == -1) {
            return 0;
        }

        if (str.charAt(start) == '-' || str.charAt(start) == '+') {
            if (length == 1 || str.charAt(start + 1) < '0' || str.charAt(start + 1) > '9') {
                return 0;
            }
        }

        return getIntFromString(str.substring(start, start+length));
    }

    private int getIntFromString(String substring) {
        // 需要考虑整形溢出
        int result;
        try {
            result = Integer.parseInt(substring);
        } catch (NumberFormatException e) {
            if (substring.charAt(0) == '-') {
                result = Integer.MIN_VALUE;
            } else {
                result = Integer.MAX_VALUE;
            }
        }

        return result;
    }
}
