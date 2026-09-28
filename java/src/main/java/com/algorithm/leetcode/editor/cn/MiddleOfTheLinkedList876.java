//给定一个头结点为 head 的非空单链表，返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = 
//NULL.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 给定链表的结点数介于 1 和 100 之间。 
// 
// Related Topics 链表 双指针 👍 415 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.ListNode;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-11 15:27:04
 */
public class MiddleOfTheLinkedList876 {

//leetcode submit region begin(Prohibit modification and deletion)

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
    class Solution {

        public ListNode middleNode(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode p1 = head, p2 = head;
            while (p2 != null && p2.next != null) {
                p1 = p1.next;
                p2 = p2.next.next;
            }
            return p1;
        }

        public ListNode middleNode2(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode p1 = head, p2 = head.next;
            while (p2 != null) {
                p1 = p1.next;
                p2 = p2.next == null ? null : p2.next.next;
            }
            return p1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        ListNode root = ListNode.create(1, 1);
        Solution solution = new MiddleOfTheLinkedList876().new Solution();
        System.out.println(solution.middleNode(root));
    }

}