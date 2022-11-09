package com.bear.stack;

import java.util.ArrayDeque;

// 回文链表
public class Question234 {

    public boolean isPalindrome(ListNode head) {
        // 直接字符串拼接一下
        StringBuilder tmp = new StringBuilder();
        while (head != null) {
            tmp.append(head.val);
            head = head.next;
        }
        return tmp.toString().equals(tmp.reverse().toString());
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}