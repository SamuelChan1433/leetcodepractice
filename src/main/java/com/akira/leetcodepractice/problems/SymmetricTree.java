package com.akira.leetcodepractice.problems;

import com.akira.leetcodepractice.tools.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：LeetCode 101.对称二叉树
 * 解法：bfs广度优先算法
 * 其他解法：递归
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(new Integer[] {1,2,3,4,5});

        System.out.println("result is: " + isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode subRoot;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size];

            // 构建数值数组，存放二叉树的每一行节点的值
            for (int i = 0; i < size; i++) {
                subRoot = queue.poll();
                arr[i] = subRoot == null ? Integer.MAX_VALUE : subRoot.val;
                if (subRoot != null) {
                    queue.add(subRoot.left);
                    queue.add(subRoot.right);
                }
            }

            // 判断是否回文
            for (int i = 0; i < size/2; i++) {
                if (arr[i] != arr[size - i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}