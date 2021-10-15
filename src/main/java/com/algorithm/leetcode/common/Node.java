package com.algorithm.leetcode.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-14 19:56
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    /**
     * 创建N叉树，使用null作为层的分隔
     *
     * @param arr 数组
     * @return 树头节点
     */
    public static Node create(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(arr[0]);
        int count = 0;
        Node current = root;
        queue.add(root);
        int len = queue.size() - 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == null) {
                if (count == len) {
                    count = 0;
                    len = queue.size() - 1;
                } else {
                    count++;
                }
                current = queue.poll();
            } else {
                Node node = new Node(arr[i]);
                queue.offer(node);
                if (current.children == null) {
                    current.children = new ArrayList<>();
                }
                current.children.add(node);
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }

    public static void main(String[] args) {
//        Node node = create(new Integer[]{1, null, 3, 2, 4, null, 5, 6});

        Node node = create(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14});
        Node node1 = create(new Integer[]{1, null});

    }

}
