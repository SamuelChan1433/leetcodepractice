package com.akira.leetcodepractice.problems;

import com.akira.leetcodepractice.tools.TreeNode;

/**
 * 题目：LeetCode 124 二叉树中的最大路径
 */
public class MaxPathSum {

    public static void main(String[] args) {

        Integer [] test = new Integer[] {-10,9,20,null,null,15,7};
        //TreeNode root = TreeNode.initTree(test);
        TreeNode treeNode = TreeNode.initTree(test);
        //TreeNode.printTree(treeNode);
        System.out.println(new MaxPathSum().maxPathSum(treeNode));
    }

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(maxGain(root.left), 0);
        int rightSum = Math.max(maxGain(root.right), 0);

        // 最大路径= 中 + 左 + 右
        int newMaxPath = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, newMaxPath);

        // 本节点的最大贡献值 = 中+ max(左, 右)
        return root.val + Math.max(leftSum, rightSum);
    }
}
