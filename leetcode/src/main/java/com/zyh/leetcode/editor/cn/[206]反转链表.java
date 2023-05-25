package com.zyh.leetcode.editor.cn;
import com.zyh.leetcode.editor.cn.common.ListNode;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList1(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        slow.next = null;
        while (fast != null){
            //使用快慢指针，原地改变链表的next
            ListNode tmp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = tmp;
        }
        return slow;
    }

    /**
     * 递归算法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode listNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    /**
     * 递归用法
     * @param slow
     * @param fast
     * @return
     */
    public ListNode reverse(ListNode slow, ListNode fast) {
        if (fast == null) {
            return slow;
        }
        ListNode tmp = fast.next;
        fast.next = slow;
        slow = fast;
        return reverse(slow, tmp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
