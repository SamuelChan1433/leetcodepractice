package com.akira.leetcodepractice.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：LeetCode 95 不同的二叉树
 */
public class GenerateTrees {

    public static void main(String[] args) {
        // [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
        int n = 3;
        List<TreeNode> nodeList = new GenerateTrees().generateTrees(n);
        for (TreeNode node : nodeList) {
            printNodeTree(node);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        if (start > end) {
            return new ArrayList<>();
        }

        List<TreeNode> results = new ArrayList<>();
        TreeNode root;
        List<TreeNode> left;
        List<TreeNode> right;
        for (int i = start; i <= end; i++) {
            // left tree
            left = generateTrees(start, i-1);
            // right tree
            right = generateTrees(i+1, end);

            if (left.size() > 0 && right.size() > 0) {
                for (TreeNode leftNode : left) {
                    for (TreeNode rightNode: right) {
                        root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        results.add(root);
                    }
                }
            } else if (left.size() > 0) {
                for (TreeNode leftNode : left) {
                    root = new TreeNode(i);
                    root.left = leftNode;
                    results.add(root);
                }
            } else if (right.size() > 0) {
                for (TreeNode rightNode : right) {
                    root = new TreeNode(i);
                    root.right = rightNode;
                    results.add(root);
                }
            } else {
                root = new TreeNode(i);
                results.add(root);
            }
        }

        return results;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static void printNodeTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        StringBuilder stringBuilder = new StringBuilder();
        while (queue.size() > 0) {
            TreeNode root = queue.poll();
            if (root != null ) {
                stringBuilder.append(root.val).append(" ");
                queue.add(root.left);
                queue.add(root.right);
            } else {
                stringBuilder.append("null ");
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
