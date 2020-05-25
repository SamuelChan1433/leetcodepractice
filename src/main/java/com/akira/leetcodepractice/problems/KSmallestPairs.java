package com.akira.leetcodepractice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 题目：LeetCode 373 查找最小的K对数字
 */
public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int x = 0;
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, new Cmp());

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.add(Arrays.asList(nums1[i], nums2[j]));

            }
        }

        //return k > resultList.size() ? resultList : resultList.subList(0, k);
        while (!queue.isEmpty() && x < k) {
            resultList.add(queue.poll());
            x++;
        }
        return resultList;
    }

    class Cmp implements Comparator<List<Integer>> {

        public int compare(List<Integer> L1, List<Integer> L2) {
            if (L1.get(0) + L1.get(1) < L2.get(0) + L2.get(1)) {
                return -1;
            }
            if (L1.get(0) + L1.get(1) > L2.get(0) + L2.get(1)) {
                return 1;
            }

            return 0;
        }
    }
}
