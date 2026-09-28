//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
// 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
// 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 237 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-21 16:07:13
 */
public class CousinsInBinaryTree993 {

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

        public boolean isCousins(TreeNode root, int x, int y) {
            Stack<TreeNode> xs = getStack(root, x);
            Stack<TreeNode> ys = getStack(root, y);
            return xs.size() == ys.size() && xs.pop() != ys.pop();
        }

        public Stack<TreeNode> getStack(TreeNode root, int target) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode last = null;
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.peek();
                    if (root.right == null || root.right == last) {
                        last = stack.pop();
                        if (last.val == target) {
                            return stack;
                        }
                        root = null;
                    } else {
                        root = root.right;
                    }
                }
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new CousinsInBinaryTree993().new Solution();
    }

}