package com.akira.leetcodepractice.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：LeetCode 200 岛屿数量
 * 本次解法：广度优先算法
 * 其他解法：深度优先算法。并查法
 */
public class IslandCount {

    boolean [][] isVisited;
    int[] dirX = new int[] {-1, 0, 1, 0};
    int[] dirY = new int[] {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        isVisited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isVisited[i][j] && isLand(grid, i, j)) {
                    count++;
                    searchLand(grid, i, j);
                }
            }
        }

        return count;
    }

    private void searchLand(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        isVisited[i][j] = true;
        queue.add(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] land = queue.poll();
            int x = land[0];
            int y = land[1];
            for (int k = 0; k < 4; k ++) {
                int searchX = x + dirX[k];
                int searchY = y + dirY[k];
                if (outOfArr(searchX, searchY, grid.length, grid[0].length)) {
                    continue;
                }

                // add to queue
                if (isLand(grid, searchX, searchY) && !isVisited[searchX][searchY]) {
                    isVisited[searchX][searchY] = true;
                    queue.add(new int[] {searchX, searchY});
                }
            }
        }
    }

    private boolean isLand(char[][] grid, int i, int j) {
        return grid[i][j] == '1';
    }

    private boolean outOfArr(int x, int y, int length, int height) {
        return (x < 0 || x >= length || y < 0 || y >= height);
    }


    public static void main(String[] args) {
        char[][] test = new char[][] {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };

        char[][] test2 = new char[][] {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        char[][] test3 = new char[][] {
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
                {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
                {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
                {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'}
        };

        System.out.println(new IslandCount().numIslands(test3));
    }
}

