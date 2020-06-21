package com.akira.leetcodepractice.problems;

import java.util.Arrays;

/**
 * 题目：LeetCode 1300 转变数组后最接近目标的数组和
 */
public class FindBestValue {

    public static void main(String[] args) {
        int[] arr1 = new int[] {9, 4, 3};
        int target1 = 10;
        //System.out.println(new FindBestValue().findBestValue(arr1, target1));

        int[] arr2 = new int[] {2, 3, 5};
        int target2 = 10;
        //System.out.println(new FindBestValue().findBestValue(arr2, target2));

        int[] arr3 = new int[] {1547,83230,57084,93444,70879};
        int target3 = 71237;
        System.out.println(new FindBestValue().findBestValue(arr3, target3));
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int size = arr.length;
        int sum =  getArraySum(arr, size);

        // returnVal = target[size - 1]
        if (target >= sum) {
            return arr[size -1];
        }

        // returnVal < target[0];
        if (target <= size * arr[0]) {
            int returnVal = target / size;
            int returnVal2 = returnVal + 1;

            return Math.abs(target - returnVal*size) < Math.abs(target - returnVal2*size) ?
                    returnVal : returnVal2;
        }

        // returnVal in (target[0], target[size-1])
        return getBest(arr, target, size);
    }

    private int getBest(int[] arr, int target, int size) {
        int returnVal = arr[size-1];
        int[] temp = new int[size];
        int[] sumArr = new int[arr[size-1] - arr[0] + 1];
        sumArr[0] = size*arr[0];

        int k = 0;
        for (int i = arr[0]+1; i < arr[size-1]; i++) {
            for (int j = 0; j < size; j++) {
                temp[j] = Math.min(arr[j], i);
            }
            k++;
            sumArr[k] = getArraySum(temp, size);
            if (sumArr[k] >= target) {
                returnVal = Math.abs(target - sumArr[k]) < Math.abs(target - sumArr[k - 1])
                        ? i : i - 1;
                break;
            }
        }
        return returnVal;
    }

    private int getArraySum(int[] arr, int size) {
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += arr[i];
        }

        return result;
    }
}
