//给定一个 N 叉树，返回其节点值的 后序遍历 。 
//
// N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
// 
// 
//
// 进阶： 
//
// 递归法很简单，你可以使用迭代法完成此题吗? 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[5,6,3,2,4,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的高度小于或等于 1000 
// 节点总数在范围 [0, 10^4] 内 
// 
// 
// 
// Related Topics 栈 树 深度优先搜索 👍 160 👎 0

package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-14 20:46:38
 */
public class NAryTreePostorderTraversal590 {

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {

        public List<Integer> postorder(Node root) {
            List<Integer> nodes = new ArrayList<>();
            if (root == null) {
                return nodes;
            }
            recur(nodes, root);
            return nodes;
        }

        public void recur(List<Integer> result, Node current) {
            if (current.children == null || current.children.isEmpty()) {
                result.add(current.val);
                return;
            }
            for (Node child : current.children) {
                recur(result, child);
            }
            result.add(current.val);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Node node = Node.create(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14});
        Solution solution = new NAryTreePostorderTraversal590().new Solution();
        System.out.println(solution.postorder(node));
    }

}