package com.akira.leetcodepractice.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * 题目：LeetCode 16.21 交换和
 */
public class FindSwapValues {

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] arr2 = new int[]{3, 6, 3, 3};

        int[] res = new FindSwapValues().findSwapValues(arr1, arr2);
        Arrays.stream(res).forEach(System.out::println); // [1, 3]
    }

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = getSum(array1);
        int sum2 = getSum(array2);
        int cha = sum1-sum2;
        if (cha % 2 == 1) {
            return new int[]{};
        }


        for (int swap1:array1) {
            for (int swap2:array2) {
                if (cha > 0 && swap1 <= swap2) {
                    continue;
                } else if (cha < 0 && swap1 >= swap2) {
                    continue;
                }
                if (2*(swap1 - swap2) == cha) {
                    return new int[]{swap1, swap2};
                }
            }
        }

        return new int[]{};
    }

    private int getSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }
}
