package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 35 搜索插入位置
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 5, 6};
        int target = 5; // 2
        System.out.println("" + new SearchInsert().searchInsert(test, target));

        target = 2; // 1
        System.out.println("" + new SearchInsert().searchInsert(test, target));

        target = 7; // 4
        System.out.println("" + new SearchInsert().searchInsert(test, target));

        target = 0; // 0
        System.out.println("" + new SearchInsert().searchInsert(test, target));

        test = new int[]{1, 3};
        target = 4; // 2
        System.out.println("" + new SearchInsert().searchInsert(test, target));
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int i = start + (end - start) / 2;
        int x;
        if (i >= nums.length) {
            return nums.length;
        }

        if (end - start == 0) {
            return target <= nums[start] ? start : start+1;
        }

        x = target - nums[i];
        if (x == 0) {
            return i;
        }

        // 左边
        if (x < 0) {
            return binarySearch(nums, start, i, target);
        }

        // 右边
        return binarySearch(nums, i + 1, end, target);
    }
}
