package com.LianBiao;

import com.node.LinkNode;
import com.node.ListNode;

import java.util.List;

//zhuanlianbiao, Kgeyizu
public class ReverseKGroup {
    public static void main(String[] args){
        ListNode pre = new ListNode(-1);
        ListNode head=construct();
        pre.next = head;
        ListNode result = reverLiannbiao(2, head, pre);
        printValue(result);
    }
    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    public static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = new ListNode(-1);
        ListNode cur=head, next=head.next;
        // while 终止的条件改一下就行了
        while (head != b) {
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    public static int comLength(ListNode node){
        ListNode temp = node;
        int k = 0;
        while (temp!=null) {
            k++;
            temp = temp.next;
        }
        return k;
    }

    public static ListNode construct() {
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(7);
        first.next = second;
        second.next = third;
        third.next=four;
        four.next = five;
        five.next = six;
        return first;
    }
    public static void printValue(ListNode node){
        while (node!=null){
            System.out.print(node.val);
            node = node.next;
        }
    }
}
