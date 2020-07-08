package com.akira.leetcodepractice.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：LeetCode 112 路径总和
 */
public class HasPathSum {

    public static void main(String[] args) {

//        Integer[] test = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
//        int sum = 22; // true
//        TreeNode root = init(test);
//        System.out.println(new HasPathSum().hasPathSum(root, sum));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int pathSum = 0;
        while (!stack.isEmpty()) {
            TreeNode tmpRoot = stack.pop();
            if (tmpRoot != null) {
                boolean isLeave = addNode(stack, tmpRoot.val, tmpRoot.left, tmpRoot.right);
                if (isLeave && tmpRoot.val == sum) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean addNode(Stack<TreeNode> stack, int val, TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null) {
            left.val += val;
            stack.push(left);
        }

        if (right != null) {
            right.val += val;
            stack.push(right);
        }

        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
