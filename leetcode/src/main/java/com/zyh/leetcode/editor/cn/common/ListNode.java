package com.zyh.leetcode.editor.cn.common;

import java.util.HashMap;

public class ListNode {
   public int val;
   public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildListNode(int... list){
        ListNode node = new ListNode();
        ListNode head = node;
        for (int i : list) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head.next;
    }

    /**
     * 构建从链尾连接到指定某个未知节点的环形链表
     * @param list
     * @param pos 第几个节点是环形链表的连接点
     * @return
     */
    public static ListNode buildCycleListNode(int pos,int... list){
        var map = new HashMap<Integer, ListNode>();
        ListNode node = new ListNode();
        ListNode head = node;
        for (int i = 0; i < list.length; i++) {
            ListNode tmp = new ListNode(list[i]);
            map.put(i, tmp);
            node.next =tmp;
            node = node.next;
        }
        ListNode tailNode = map.get(list.length - 1);
        tailNode.next = map.get(pos);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = buildCycleListNode(1,3,2,0,-4);
        while (node!=null){
            System.out.println(node.val);
        }
    }
}
