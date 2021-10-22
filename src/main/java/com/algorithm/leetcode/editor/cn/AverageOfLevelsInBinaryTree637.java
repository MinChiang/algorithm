//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 292 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-22 11:01:56
 */
public class AverageOfLevelsInBinaryTree637 {

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

        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Double> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                long sum = 0;
                for (int i = 0; i < size; i++) {
                    root = queue.poll();
                    sum += root.val;
                    if (root.left != null) {
                        queue.offer(root.left);
                    }
                    if (root.right != null) {
                        queue.offer(root.right);
                    }
                }
                result.add((double) sum / size);
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree637().new Solution();
    }

}