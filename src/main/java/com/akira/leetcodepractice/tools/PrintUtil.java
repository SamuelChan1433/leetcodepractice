package com.akira.leetcodepractice.tools;

import java.util.LinkedList;

public class PrintUtil {
    public static void printArr(int[] result) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            stringBuilder.append(result[i]).append(" ");
        }

        stringBuilder.append(System.lineSeparator());
        System.out.println(stringBuilder.toString());
    }

    public static void printList(LinkedList<Integer> reversedArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : reversedArr) {
            stringBuilder.append(i).append(" ");
        }

        stringBuilder.append(System.lineSeparator());
        System.out.println(stringBuilder.toString());
    }
}
