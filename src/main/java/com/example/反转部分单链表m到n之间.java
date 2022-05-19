package com.example;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class 反转部分单链表m到n之间 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode reverseBetween(ListNode head, int m, int n) {
            /**
             * 1）找到m-1节点mPre节点和n+1节点 nPos
             * 2）反转m到n
             * 3）拼接  如果mPre等于null  返回新头节点
             */
            int len = 0;
            ListNode cur1 = head;
            //反转开始节点的前一个节点
            ListNode mPre = null;
            //反转结束节点的下一个节点
            ListNode nPos = null;
            //找到m-1节点mPre节点和n+1节点 nPos
            while (cur1 != null) {
                len++;
                mPre = len == m - 1 ? cur1 : mPre;
                nPos = len == n + 1 ? cur1 : nPos;
                cur1 = cur1.next;
            }
            //参数校验
            if (m > n || m < 1 || n > len) {
                return head;
            }
            //反转部分包含头节点，返回新头节点
            //cur1是当前待反转节点
            cur1 = mPre == null ? head : mPre.next;
            //cur2是当前待反转节点的下一个节点 如果等于nPos说明cur1是最后一个待反转节点
            ListNode cur2 = cur1.next;
            //cur1是已经反转好的头节点
            cur1.next = nPos;
            ListNode next = null;
            while (cur2 != nPos) {
                //保存下一个待反转节点
                next = cur2.next;
                //指向反转好的头节点
                cur2.next = cur1;
                //cur2成为新的反转好的头节点
                cur1 = cur2;
                cur2 = next;
            }
            //待反转节点左边有节点，使用原来的头
            if (mPre != null) {
                mPre.next = cur1;
                return head;
            }
            return cur1;
        }
    }
}
 