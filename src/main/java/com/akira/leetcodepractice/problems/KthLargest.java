package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 215 数组中的最大元素
 */
public class KthLargest {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k_smallest) {
        if (left == right) {
            return nums[left];
        }

        // 选取基准 位
        int pivot_index = left;
        // 把小于基准的数放到基准数左边
        pivot_index = rebalance(nums, pivot_index, left, right);

        if (k_smallest == pivot_index) {
            return nums[k_smallest];
        } else if (k_smallest < pivot_index) {
            return quickSelect(nums, left, pivot_index - 1, k_smallest);
        }

        return quickSelect(nums, pivot_index + 1, right, k_smallest);
    }


    private static int rebalance(int[] nums, int pivot_index, int left, int right) {
        int base = nums[pivot_index];
        int flag = right;

        for (int i = right; i > left; i--) {
            if (nums[i] >= base) {
                swap(nums, i, flag);
                flag--;
            }
        }

        swap(nums, pivot_index, flag);

        return flag;
    }


    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
