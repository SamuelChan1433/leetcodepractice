package com.akira.leetcodepractice.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OceanDistance {
    public static void main(String[] args) {
        // [[0,0,1,1,1],[0,1,1,0,0],[0,0,1,1,0],[1,0,0,0,0],[1,1,0,0,1]]
        /*int[][] grid = new int[][] {
                {0, 0, 1, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}
        };*/
        int[][] grid = new int[][] {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0},
        };

        long t1 = System.currentTimeMillis();
        System.out.println(new Solution2().maxDistance(grid));
        long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) + "ms");
    }
}

class Solution2 {
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

class Solution {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int length = grid.length;
        int height = grid[0].length;
        List<int[]> land = new ArrayList<int[]>();
        int landSize = 0;

        // 遍历第一遍，找出陆地
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == 1) {
                    land.add(new int[] {i, j});
                    landSize++;
                }
            }
        }

        if (landSize == 0 || landSize == length*height) {
            return -1;
        }

        int maxDistance = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (grid[i][j] == 0) {
                    maxDistance = Math.max(maxDistance, getMinDistanceFromLand(land, landSize, i, j));
                }
            }
        }

        return maxDistance;
    }

    private int getMinDistanceFromLand(List<int[]> land, int landSize, int i, int j) {
        int distance = Integer.MAX_VALUE;
        for (int k = 0; k < landSize; k++) {
            int d = Math.abs(i - land.get(k)[0])
                    + Math.abs(j - land.get(k)[1]);
            distance = Math.min(distance,
                    d);
            if (distance == 1) {
                break;
            }
        }

        return distance;
    }
}
