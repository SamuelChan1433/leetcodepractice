package com.akira.leetcodepractice.problems;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int [] nums) {
        mergeSort(nums, 0, nums.length -1);
    }

    private static int[] mergeSort(int[] nums, int left, int right) {
        int length = right - left + 1;
        if (length <= 1) {
            return new int[] {nums[left]};
        }

        // 分
        int[] tmp1 = mergeSort(nums, left, right - length/2);
        int[] tmp2 = mergeSort(nums, right - length/2 + 1, right);

        // 治: 此时[left, right-length/2] 与 [right-length/2+1, right]有序
        int i = 0, j = 0;
        int k = left;
        while (i < tmp1.length && j < tmp2.length) {
            if (tmp1[i] <= tmp2[j]) {
                nums[k++] = tmp1[i++];
            } else {
                nums[k++] = tmp2[j++];
            }
        }
        while (i < tmp1.length) {
            nums[k++] = tmp1[i++];
        }

        while (j < tmp2.length) {
            nums[k++] = tmp2[j++];
        }

        // 合
        return Arrays.copyOfRange(nums, left, right+1);
    }
}
