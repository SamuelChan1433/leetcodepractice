package com.akira.leetcodepractice.problems;

import com.akira.leetcodepractice.tools.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：LeetCode 350 两个数组的交集II
 */
public class Intersect {
    public static void main(String[] args) {
        int[] test1 = new int[]{1,2,2,1,7};
        int[] test2 = new int[]{2,2};

        PrintUtil.printArr(new Intersect().intersect(test1, test2));
    }

    /**
     * hashMap
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!count.containsKey(nums1[i])) {
                count.put(nums1[i], 1);
            } else {
                count.put(nums1[i],  count.get(nums1[i]) + 1);
            }
        }

        int[] result = new int[count.size()];
        int k = 0;
        for (int j = 0; j < nums2.length; j++) {
            if (count.get(nums2[j]) != null && count.get(nums2[j]) > 0) {
                count.put(nums2[j],  count.get(nums2[j]) - 1);
                result[k++] = nums2[j];
            }
        }

        return Arrays.copyOfRange(result, 0, k);
    }

    public int[] intersectByEach(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        boolean[] flag = new boolean[m];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!flag[j] && nums2[i] == nums1[j]) {
                    flag[j] = true;
                    result.add(nums2[i]);
                    break;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
