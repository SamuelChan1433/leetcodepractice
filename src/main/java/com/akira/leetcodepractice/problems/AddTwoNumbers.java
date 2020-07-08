package com.akira.leetcodepractice.problems;

/**
 * 题目：LeetCode 2 两数相加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode testCase1 = new ListNode(2);
        ListNode testCase2 = new ListNode(5).append(6).append(4);
        printListNode(new AddTwoNumbers()
                .addTwoNumbers(testCase1, testCase2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] rootInitResult = addNodeListVal(l1.val, l2.val, 0);
        ListNode result = new ListNode(rootInitResult[0]);
        int adder = rootInitResult[1];

        int lengthA1 = getLength(l1);
        int lengthA2 = getLength(l2);
        int itr = 1;
        ListNode tmpNode = result;
        l1 = l1.next;
        l2 = l2.next;
        while (itr < lengthA1 && itr < lengthA2) {
            int[] addNodeResult = addNodeListVal(l1.val, l2.val, adder);
            tmpNode.next = new ListNode(addNodeResult[0]);
            adder = addNodeResult[1];
            tmpNode = tmpNode.next;

            l1 = l1.next;
            l2 = l2.next;
            itr++;
        }

        // if长度不一致
        while (itr < lengthA1) {
            int[] addNodeResult = addNodeListVal(l1.val, 0, adder);
            tmpNode.next = new ListNode(addNodeResult[0]);
            adder = addNodeResult[1];
            l1 = l1.next;
            tmpNode = tmpNode.next;
            itr++;
        }

        while (itr < lengthA2) {
            int[] addNodeResult = addNodeListVal(0, l2.val, adder);
            tmpNode.next = new ListNode(addNodeResult[0]);
            adder = addNodeResult[1];
            l2 = l2.next;
            tmpNode = tmpNode.next;
            itr++;
        }

        if (adder > 0) {
            tmpNode.next = new ListNode(adder);
        }
        return result;
    }

    private int[] addNodeListVal(int l1, int l2, int adder) {
        int result = l1 + l2 + adder;
        if (result >= 10) {
            adder = result / 10;
            result -= adder*10;
        } else {
            adder = 0;
        }
        return new int[]{result, adder};
    }

    private int getLength(ListNode listNode) {
        int length = 0;
        ListNode tmp = listNode;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }

        return length;
    }

    private static void printListNode(ListNode testCase1) {
        ListNode tmp = testCase1;
        while (tmp != null) {
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        ListNode append(int x) {
            if (next == null) {
                next = new ListNode(x);
                return this;
            }

            ListNode tmp = next;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new ListNode(x);
            return this;
        }
    }
}
