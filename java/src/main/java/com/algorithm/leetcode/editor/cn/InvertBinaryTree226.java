//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//      4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//      4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1026 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-11 16:00:52
 */
public class InvertBinaryTree226 {

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

        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            return root;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {

        TreeNode root = TreeNode.create(new Integer[]{4, 2, 7, 1, 3, 6, 9});

        Solution solution = new InvertBinaryTree226().new Solution();
        solution.invertTree(root);
        System.out.println(root.toHierarchyString());
    }

}