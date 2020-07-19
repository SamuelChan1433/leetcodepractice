package com.akira.leetcodepractice.problems;

import com.akira.leetcodepractice.tools.PrintUtil;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：LeetCode 785 判断二分图
 */
public class Bipartite {

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1},
                {0, 3},
                {3},
                {1, 2}
        };
        // true
        System.out.println(new Bipartite().isBipartite(graph));

        graph = new int[][] {{4},{},{4},{4},{0,2,3}};
        // true
        System.out.println(new Bipartite().isBipartite(graph));

        graph = new int[][] {{}};
        // true
        System.out.println(new Bipartite().isBipartite(graph));

        graph = new int[][] {{0}};
        // false
        System.out.println(new Bipartite().isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {

        // color a = 1, color b = -1
        int[] colors = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        int nextColor;

        for (int j = 0; j < graph.length; j++) {
            if (colors[j] == 0) {
                colors[j] = 1;
                queue.add(j);
            }
            while (queue.size() > 0) {
                int index = queue.poll();
                int[] neighbors = graph[index];
                nextColor = colors[index] * -1;

                for (int i : neighbors) {
                    if (colors[i] == 0) {
                        colors[i] = nextColor;
                        queue.add(i);
                    } else if (colors[i] != nextColor) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
