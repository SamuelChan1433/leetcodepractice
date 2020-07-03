package com.akira.leetcodepractice.tools;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 自定义二叉树
 */
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer x) {
        val = x;
    }

    /**
     * 通过数组初始化二叉树
     *
     * @param arr 初始化数组
     *            [1,2,3,4,5]
     * @return root节点 1
     */
    public static TreeNode initTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (queue.size() > 0) {
            TreeNode tempRoot = queue.poll();
            if (tempRoot == null) {
                continue;
            }
            tempRoot.left = generateNode(arr, i++);
            tempRoot.right = generateNode(arr, i++);
            queue.add(tempRoot.left);
            queue.add(tempRoot.right);
        }

        return root;
    }

    private static TreeNode generateNode(Integer[] arr, int i) {
        if (i < arr.length && arr[i] != null) {
            return new TreeNode(arr[i]);
        }
        return null;
    }

    public static void printTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        int lineSize = queue.size();
        while (queue.size() > 0) {
            for (int i = 0; i < lineSize; i++) {
                TreeNode tmp = queue.poll();
                if (tmp == null) {
                    stringBuilder.append("null");
                } else {
                    stringBuilder.append(tmp.val);
                    queue.add(tmp.left);
                    queue.add(tmp.right);
                }

                stringBuilder.append(" ");
            }
            stringBuilder.append(System.lineSeparator());
            lineSize = queue.size();
        }

        System.out.println(stringBuilder.toString());
    }
}
