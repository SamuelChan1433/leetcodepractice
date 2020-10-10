package com.akira.leetcodepractice.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 题目：LeetCode 347 前K个高频元素
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0;i < nums.length; i++) {
            if (countMap.get(nums[i]) == null) {
                countMap.put(nums[i], 1);
            } else {
                countMap.put(nums[i], countMap.get(nums[i])+1);
            }
        }

        PriorityQueue<int[]> priorityTree = new PriorityQueue<>(k + 1,
                Comparator.comparingInt(arr -> arr[1])
        );
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();
            if (priorityTree.size() < k) {
                priorityTree.offer(new int[]{number, count});
            } else if (priorityTree.peek()[1] < count) {
                priorityTree.poll();
                priorityTree.offer(new int[]{number, count});
            }
        }


        int[] result = new int[k];
        int j = 0;
        for (int[] arr : priorityTree) {
            result[j++] = arr[0];
        }
        return result;
    }
}
