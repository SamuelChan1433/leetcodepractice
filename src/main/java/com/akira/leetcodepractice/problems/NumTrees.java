package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 96 不同的二叉搜索树
 */
public class NumTrees {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new NumTrees().numTrees(n));
    }

    /**
     * g(n): n个节点的序列能够组成的二叉树数量
     * f(i,n) : 以i为根节点组成的二叉树数量
     * -> g(n) = sum[i=1...n](g(i-1) * g(n-i))
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] = g[i] + (g[j-1] * g[i-j]);
            }
        }

        return g[n];
    }
}
