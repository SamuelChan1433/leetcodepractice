package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 240 搜索二维矩阵II
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // 取矩阵右上角的数字
        int item;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            item = matrix[i][j];
            if (item == target) {
                return true;
            } else if (item < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
