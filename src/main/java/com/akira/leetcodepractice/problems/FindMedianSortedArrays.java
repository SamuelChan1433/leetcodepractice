/*
 * 题目：LeetCode
 */

package com.akira.leetcodepractice.problems;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] test1 = new int[] {1, 3};
        int[] test2 = new int[] {2};

        System.out.println(new FindMedianSortedArrays()
                .findMedianSortedArrays(test1, test2));
    }

    /**
     * 返回中位数
     *
     * @param num1 升序数组1
     * @param num2 升序数组2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] num1, int[] num2) {
        if (num1 == null) {
            return findMid(num2);
        }
        if (num2 == null) {
            return findMid(num1);
        }

        int[] allArr = mergeArr(num1, num2);
        return findMid(allArr);
    }

    private double findMid(int[] num2) {
        int size = num2.length;
        if (size % 2 == 0) {
            return (num2[size/2] + num2[size/2-1]) / 2.0;
        }

        return num2[size/2];
    }

    private int[] mergeArr(int[] num1, int[] num2) {
        int[] result = new int[num1.length + num2.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (k < result.length) {
            if (i >= num1.length) {
                addAllArr(result, k,  num2, j);
                return result;
            } else if (j >= num2.length) {
                addAllArr(result, k, num1, i);
                return result;
            }

            if (num1[i] < num2[j]) {
                result[k++] = num1[i++];
            } else {
                result[k++] = num2[j++];
            }
        }

        return result;
    }

    private void addAllArr(int[] result, int k, int[] arr, int startIndex) {
        while (k < result.length) {
            result[k++] = arr[startIndex++];
        }
    }
}
