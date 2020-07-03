package com.akira.leetcodepractice.problems;

import com.akira.leetcodepractice.tools.TreeNode;

/**
 * 题目：LeetCode 108 将有序数组转二叉搜索树
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] test = new int[]{-10,-3,0,5,9};
        TreeNode.printTree(new SortedArrayToBST().sortedArrayToBST(test));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int size = nums.length;
        return toBST(nums, 0, size-1);
    }

    private TreeNode toBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int size = end - start + 1;
        TreeNode root = new TreeNode(nums[start + size/2]);
        TreeNode left = toBST(nums, start, start + size/2 - 1);
        TreeNode right = toBST(nums, start + size/2 + 1, end);

        if (left != null) {
            root.left = left;
        }

        if (right != null) {
            root.right = right;
        }

        return root;
    }
}
