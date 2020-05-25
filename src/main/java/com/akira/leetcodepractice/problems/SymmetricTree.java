package com.akira.leetcodepractice.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：LeetCode 101.对称二叉树
 * 解法：bfs广度优先算法
 * 其他解法：递归
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.initTree();

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


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }

    void initTree() {
         TreeNode currentNode = this;
         currentNode.left = new TreeNode(2);
         currentNode.right = new TreeNode(2);

         currentNode = this.left;
         currentNode.left = null;
         currentNode.right = new TreeNode(3);

         currentNode = this.right;
         currentNode.left=null;
         currentNode.right = new TreeNode(3);
    }


    void initTree2() {
        TreeNode currentNode = this;
        currentNode.left = new TreeNode(3);
        currentNode.right = new TreeNode(3);

        currentNode = this.left;
        currentNode.left = new TreeNode(4);
        currentNode.right = new TreeNode(5);

        currentNode = this.right;
        currentNode.left = new TreeNode(5);
        currentNode.right = new TreeNode(4);

        currentNode = this.left.left;
        currentNode.left = null;
        currentNode.right = null;

        currentNode = this.left.right;
        currentNode.left = new TreeNode(8);
        currentNode.right = new TreeNode(9);

        currentNode = this.right.left;
        currentNode.left = new TreeNode(9);
        currentNode.right = new TreeNode(8);
    }
}