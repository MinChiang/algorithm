package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-09-30 11:35
 */
public class BinaryTreeInorderTraversal94 {

    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode tmp = stack.pop();
                result.add(tmp.val);
                current = tmp.right;
            }
        }
        return result;
    }

    // 前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            } else {
                TreeNode tmp = stack.pop();
                current = tmp.right;
            }
        }
        return result;
    }

    // 后续遍历
    public List<Integer> postOrderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                // 这里判断一下对应的右子节点是否为空，还有当前的右侧节点和上次遍历的节点是否一致
                if (node.right == null || node.right == last) {
                    result.add(node.val);
                    last = node;
                    stack.pop();
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal94 binaryTreeInorderTraversal94 = new BinaryTreeInorderTraversal94();
        TreeNode root = TreeNode.create(IntStream.range(1, 7).boxed().toArray(Integer[]::new));
        // 4 2 5 1 6 3
//        System.out.println(binaryTreeInorderTraversal94.inorderTraversal(root));
        // 4 5 2 6 3 1
        System.out.println(binaryTreeInorderTraversal94.postOrderTraversal(root));
    }

}
