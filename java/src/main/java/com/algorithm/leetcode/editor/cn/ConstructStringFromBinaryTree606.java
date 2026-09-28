//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。 
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 示例 1: 
//
// 
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /    
//  4     
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
// 
//
// 示例 2: 
//
// 
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \  
//      4 
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 215 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-22 10:43:31
 */
public class ConstructStringFromBinaryTree606 {

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

        public String tree2str(TreeNode root) {
            if (root == null) {
                return "()";
            }
            return recur(root);
        }

        public String recur(TreeNode node) {
            StringBuilder sb = new StringBuilder(String.valueOf(node.val));
            if (node.left == null && node.right == null) {
                return sb.toString();
            }
            sb.append("(");
            if (node.left != null) {
                sb.append(recur(node.left));
            }
            sb.append(")");
            if (node.right != null) {
                sb.append("(");
                sb.append(recur(node.right));
                sb.append(")");
            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ConstructStringFromBinaryTree606().new Solution();
        System.out.println(solution.tree2str(TreeNode.create(new Integer[]{1,2,3,null,4})));
    }

}