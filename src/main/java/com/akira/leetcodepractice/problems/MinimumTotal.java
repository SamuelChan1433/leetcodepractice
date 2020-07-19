package com.akira.leetcodepractice.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：LeetCode 120 三角形最小路径和
 */
public class MinimumTotal {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>(){{add(2);}});
            add(new ArrayList<Integer>(){{add(3); add(4);}});
            add(new ArrayList<Integer>(){{add(6); add(5); add(7);}});
            add(new ArrayList<Integer>(){{add(4); add(1); add(8); add(3);}});
        }};

        System.out.println(new MinimumTotal().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        int[][] minPath = new int[h][h];
        for (int i = h-1; i >=0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                minPath[i][j] = triangle.get(i).get(j) + getMinPathOfSon(triangle, minPath, i, j);
            }
        }

        return minPath[0][0];
    }

    private Integer getMinPathOfSon(List<List<Integer>> triangle, int[][] minPath, int i, int j) {
        int h = triangle.size();
        if (i == h-1) {
            return 0;
        }

        return Math.min(minPath[i+1][j], minPath[i+1][j+1]);
    }
}
