package com.akira.leetcodepractice.problems;

import java.util.Arrays;

/**
 * 题目：LeetCode 155 最小栈
 */
public class MinStack {
    private int size = 0;
    private Integer[] myStack = new Integer[64];
    private int[] minList = new int[64];

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minList[0] = Integer.MAX_VALUE;
        myStack[0] = null;
    }

    public void push(int x) {
        if (size == myStack.length - 1) {
            myStack = Arrays.copyOf(myStack, 2 * myStack.length);
            minList = Arrays.copyOf(minList, 2 * minList.length);
            myStack[size] = x;
        }
        size++;
        myStack[size] = x;
        minList[size] = Math.min(x, minList[size - 1]);
    }

    public void pop() {
        size--;
    }

    public int top() {
        return myStack[size];
    }

    public int getMin() {
        return minList[size];
    }
}
