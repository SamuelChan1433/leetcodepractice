package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 17.13 恢复空格
 */
public class Respace {
    public static void main(String[] args) {
        String sentence = "jesslookedjustliketimherbrother";
        String[] dictionary = new String[] {
                "looked","just","like","her","brother"
        };

        // 7
        System.out.println(new Respace().respace(dictionary, sentence));

        sentence = "abcdabc";
        dictionary = new String[] {
                "abc", "cdab"
        };

        // 1
        System.out.println(new Respace().respace(dictionary, sentence));
    }

    public int respace(String[] dictionary, String sentence) {
return 0;
    }
}
