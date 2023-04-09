package com.zyh.leetcode.editor.cn;

import com.zyh.leetcode.editor.cn.common.ListNode;
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int pCount = 0;
        while (p1 != null) {
            pCount++;
            p1 = p1.next;
            // 当p1先领先k步，由于p2落后p1指针k步，所以p2正好在倒数第k个位置
            if (pCount > k) {
                // p1指针只差 n-k 步就遍历完了链表
                p2 = p2.next;
            }
        }

        return p2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
