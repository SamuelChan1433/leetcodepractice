

package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 9 回文数
 */
public class Palindrome {
    public static void main(String[] args) {
//        System.out.println(new Palindrome().isPalindrome(121));
//        System.out.println(new Palindrome().isPalindrome(131));
//        System.out.println(new Palindrome().isPalindrome(-121));
//        System.out.println(new Palindrome().isPalindrome(110));
        System.out.println(new Palindrome().isPalindrome(1221));
        System.out.println(new Palindrome().isPalindrome(7));
    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = (x % 10) + (reversed * 10);
            x /= 10;
        }

        return x == reversed || x == reversed / 10;
    }


    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);

        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
