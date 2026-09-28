//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。 
//
// 例如， 
//
// 
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
// 
//
// 你应该返回如下子树: 
//
// 
//      2     
//     / \   
//    1   3
// 
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。 
// Related Topics 树 二叉搜索树 二叉树 👍 161 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-22 15:44:35
 */
public class SearchInABinarySearchTree700 {

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

        public TreeNode searchBST(TreeNode root, int val) {
            return recur(root, val);
        }

        public TreeNode recur(TreeNode node, int val) {
            if (node == null) {
                return null;
            }
            if (node.val == val) {
                return node;
            }
            TreeNode tmp;
            if (node.left != null) {
                tmp = recur(node.left, val);
                if (tmp != null) {
                    return tmp;
                }
            }
            if (node.right != null) {
                tmp = recur(node.right, val);
                if (tmp != null) {
                    return tmp;
                }
            }
            return null;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new SearchInABinarySearchTree700().new Solution();
    }

}