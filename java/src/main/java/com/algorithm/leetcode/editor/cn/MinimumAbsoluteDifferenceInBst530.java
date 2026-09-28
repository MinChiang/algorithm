//给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。 
//
// 
//
// 示例： 
//
// 输入：
//
//   1
//    \
//     3
//    /
//   2
//
//输出：
//1
//
//解释：
//最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
// 
//
// 
//
// 提示： 
//
// 
// 树中至少有 2 个节点。 
// 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 
//相同 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 279 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-21 14:27:41
 */
public class MinimumAbsoluteDifferenceInBst530 {

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

        public int getMinimumDifference(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode last = null;
            Integer min = null;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    TreeNode pop = stack.pop();
                    if (last != null) {
                        if (min == null) {
                            min = Math.abs(last.val - pop.val);
                        } else {
                            min = Math.min(min, Math.abs(last.val - pop.val));
                        }
                    }
                    last = pop;
                    root = pop.right;
                }
            }
            return min;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifferenceInBst530().new Solution();
        TreeNode treeNode = TreeNode.create(new Integer[]{236, 104, 701, null, 227, null, 911});
        System.out.println(solution.getMinimumDifference(treeNode));
    }

}