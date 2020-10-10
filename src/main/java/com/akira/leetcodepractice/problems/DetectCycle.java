package com.akira.leetcodepractice.problems;

import java.util.HashSet;
import java.util.Set;

/*
 * 题目：LeetCode 142 环形链表II
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> queue = new HashSet<>();
        ListNode ptr = head;
        while (ptr != null) {
            if (queue.contains(ptr)) {
                return ptr;
            }
            queue.add(ptr);
            ptr = ptr.next;
        }

        return null;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
