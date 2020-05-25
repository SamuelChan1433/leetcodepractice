package com.akira.leetcodepractice.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：LeetCode 1162 地图分析
 */
public class MaxDistance {

    public static void main(String[] args) {
        int[][] testcase = new int[][] {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        int answer = 2;

        System.out.println(answer == new MaxDistance().maxDistance(testcase));
    }

    private static final int MAX_N = 100;
    int[] dx = new int[] { -1, 0, 1, 0};
    int[] dy = new int[] { 0, 1, 0, -1};

    int[][] gridMap;

    public int maxDistance(int[][] grid) {
        gridMap = grid;
        int dis = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dis = Math.max(dis, findMaxDis(i, j));
                }
            }
        }

        return dis;
    }

    // 使用广度优先搜索
    private int findMaxDis(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isSearched = new boolean[MAX_N+1][MAX_N+1];

        // x, y, distance count
        queue.offer(new int[]{i, j, 0});
        while (!queue.isEmpty()) {
            int[] ocean = queue.poll();
            for (int direction = 0; direction < 4; direction++) {
                int x = ocean[0] + dx[direction];
                int y = ocean[1] + dy[direction];
                if (!isInGrid(x, y)) {
                    continue;
                }

                if (!isSearched[x][y]) {
                    if (gridMap[x][y] == 1) {
                        return ocean[2] + 1;
                    }
                    isSearched[x][y] = true;
                    queue.offer(new int[]{x, y, ocean[2] + 1});
                }
            }
        }

        return -1;
    }

    private boolean isInGrid(int x, int y) {
        return x >= 0 && x < gridMap.length && y >= 0 && y < gridMap[0].length;
    }
}
