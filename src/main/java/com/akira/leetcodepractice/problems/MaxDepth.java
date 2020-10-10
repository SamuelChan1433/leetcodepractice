package com.akira.leetcodepractice.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * 题目：LeetCode 104 二叉树的最大深度
 */
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        int maxDepth = 0;
        while (queue.size() > 0) {
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            size = queue.size();
            if (size > 0) {
                maxDepth += 1;
            }
        }

        return maxDepth;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

