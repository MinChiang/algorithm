//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 
//
// 示例 1： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
// 
//
// 示例 2： 
//
// 
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
// 
//
// 示例 3： 
//
// 
//输入: root = [2,1,3], k = 4
//输出: true
// 
//
// 示例 4： 
//
// 
//输入: root = [2,1,3], k = 1
//输出: false
// 
//
// 示例 5： 
//
// 
//输入: root = [2,1,3], k = 3
//输出: true
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1, 10⁴]. 
// -10⁴ <= Node.val <= 10⁴ 
// root 为二叉搜索树 
// -10⁵ <= k <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 284 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-22 11:11:00
 */
public class TwoSumIvInputIsABst653 {

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
            int p1 = 0, p2 = list.size() - 1, n1, n2, sum;
            while (p1 < p2) {
                n1 = list.get(p1);
                n2 = list.get(p2);
                sum = n1 + n2;
                if (sum < k) {
                    // 左侧变大
                    p1++;
                } else if (sum > k) {
                    // 右侧变小
                    p2--;
                } else {
                    return true;
                }
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new TwoSumIvInputIsABst653().new Solution();
    }

}