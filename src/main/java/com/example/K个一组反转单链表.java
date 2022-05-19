package com.example;


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class K个一组反转单链表 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode reverseKGroup(ListNode head, int k) {
            if (k < 2) {
                return head;
            }
            Stack<ListNode> stack = new Stack<ListNode>();
            ListNode newHead = head;
            ListNode cur = head;
            ListNode pre = null;
            ListNode next = null;
            while (cur != null) {
                next = cur.next;
                stack.push(cur);
                if (stack.size() == k) {
                    //pre是k组节点逆序后最后1个节点指针
                    pre = resign1(stack, pre, next);
                    //cur是k组节点逆序前最后1个节点（逆序后的第一个节点）
                    newHead = newHead == head ? cur : newHead;
                }
                cur = next;
            }
            return newHead;
        }

        public ListNode resign1(Stack<ListNode> stack, ListNode left, ListNode right) {
            //right是待逆序k个节点的第一个节点
            //逆序后第一个节点
            ListNode cur = stack.pop();
            //left是前面k个节点逆序后的最后一个节点指针
            if (left != null) {
                left.next = cur;
            }
            ListNode next = null;
            while (!stack.isEmpty()) {
                next = stack.pop();
                cur.next = next;
                cur = next;
            }
            cur.next = right;
            //cur是k组节点逆序后最后1个节点指针
            return cur;
        }
    }
}
 