package com.akira.leetcodepractice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * leetcodes problem 20
 */
public class Brackets {

    private static final Map<Character, Character> BRACKETS_MAP = new HashMap<Character, Character>(){{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            System.out.println("" + isValid(input));
        }
    }

    static boolean isValid(String brackets) {
        if (brackets.isEmpty()) {
            return true;
        }
        if (brackets.length() %2 != 0) {
            return false;
        }

        Stack<Character> myStack = new Stack<Character>();

        for (int i = 0; i < brackets.length(); i++) {
            Character c = brackets.charAt(i);
            if (BRACKETS_MAP.containsKey(c)) { //  左括号
                myStack.push(c);
            }
            else if (myStack.isEmpty() || BRACKETS_MAP.get(myStack.pop()) != c) {
                return false;
            }
        }

        return myStack.isEmpty();
    }
}
