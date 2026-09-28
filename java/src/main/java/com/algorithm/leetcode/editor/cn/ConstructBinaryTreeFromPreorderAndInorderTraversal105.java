//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1254 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-12 16:40:48
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode root = new TreeNode(inorder[0]);
            return devide(preorder, inorder, 0, 0, preorder.length - 1);
        }

        public TreeNode devide(int[] preorder, int[] inorder, int pp, int il, int ir) {
            if (il > ir) {
                return null;
            }
            if (il == ir) {
                return new TreeNode(inorder[il]);
            }
            TreeNode node = new TreeNode(preorder[pp]);
            int p;
            for (p = il; p <= ir; p++) {
                if (inorder[p] == node.val) {
                    break;
                }
            }
            node.left = devide(preorder, inorder, pp + 1, il, p - 1);
            node.right = devide(preorder, inorder, pp + p - il + 1, p + 1, ir);
            return node;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal105().new Solution();
        TreeNode root = solution.buildTree(new int[]{1, 2}, new int[]{2, 1});
        System.out.println(root.toHierarchyString());
    }

}