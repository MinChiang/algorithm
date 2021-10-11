package com.algorithm.leetcode.common;

import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-09 15:57
 */
public class ListNode {

    public static final String ARROW = " -> ";
    public int val;
    public ListNode next;

    private final boolean hasRing;

    public ListNode() {
        this.hasRing = false;
    }

    public ListNode(int val) {
        this.val = val;
        this.hasRing = false;
    }

    public ListNode(int val, boolean hasRing) {
        this.val = val;
        this.hasRing = hasRing;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        this.hasRing = false;
    }

    /**
     * 创建带环链表
     *
     * @param startInclusive    开始元素
     * @param endInclusive      结束元素
     * @param lastNodeNextPoint 最后一个节点指向的节点下标位置，小于0则不带环
     * @return 创建的列表头节点
     */
    public static ListNode create(int startInclusive, int endInclusive, int lastNodeNextPoint) {
        return create(IntStream.rangeClosed(startInclusive, endInclusive).iterator(), lastNodeNextPoint);
    }

    /**
     * 创建链表
     *
     * @param startInclusive 开始元素
     * @param endInclusive   结束元素
     * @return 创建的列表头节点
     */
    public static ListNode create(int startInclusive, int endInclusive) {
        return create(IntStream.rangeClosed(startInclusive, endInclusive).iterator(), -1);
    }

    /**
     * 创建带环的链表
     *
     * @param arr               数组
     * @param lastNodeNextPoint 最后一个节点指向的节点下标位置，小于0则不带环
     * @return 创建的列表头节点
     */
    public static ListNode create(int[] arr, int lastNodeNextPoint) {
        boolean hasRing = lastNodeNextPoint < 0;
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode current = new ListNode(arr[0]), pre = current, root = current, ringEntry = null;
        for (int i = 1; i < arr.length; i++) {
            current = new ListNode(arr[i], hasRing);
            pre.next = current;
            pre = current;
            if (i == lastNodeNextPoint) {
                ringEntry = current;
            }
        }
        if (lastNodeNextPoint == 0) {
            // 指向头节点
            current.next = root;
        } else if (lastNodeNextPoint > 0) {
            // 指向其他位置
            current.next = ringEntry;
        }
        return root;
    }

    /**
     * 创建链表
     *
     * @param arr 数组
     * @return 创建的列表头节点
     */
    public static ListNode create(int[] arr) {
        return create(arr, -1);
    }

    /**
     * 创建带环链表
     *
     * @param iterator          迭代器
     * @param lastNodeNextPoint 最后一个节点指向的节点下标位置，小于0则不带环
     * @return 创建的列表头节点
     */
    public static ListNode create(Iterator<Integer> iterator, int lastNodeNextPoint) {
        Integer first = iterator.next();
        if (first == null) {
            return null;
        }
        ListNode current = new ListNode(first), pre = current, root = current, ringEntry = null;
        int count = 1;
        while (iterator.hasNext()) {
            current = new ListNode(iterator.next());
            pre.next = current;
            pre = current;
            if (count == lastNodeNextPoint) {
                ringEntry = current;
            }
            count++;
        }
        if (lastNodeNextPoint == 0) {
            // 指向头节点
            current.next = root;
        } else if (lastNodeNextPoint > 0) {
            // 指向其他位置
            current.next = ringEntry;
        }
        return root;
    }

    /**
     * 创建链表
     *
     * @param iterator 迭代器
     * @return 创建的列表头节点
     */
    public static ListNode create(Iterator<Integer> iterator) {
        return create(iterator, -1);
    }

    /**
     * 创建带环链表
     *
     * @param iterable          迭代接口
     * @param lastNodeNextPoint 最后一个节点指向的节点下标位置，小于0则不带环
     * @return 创建的列表头节点
     */
    public static ListNode create(Iterable<Integer> iterable, int lastNodeNextPoint) {
        if (iterable == null) {
            return null;
        }
        return create(iterable.iterator(), lastNodeNextPoint);
    }

    /**
     * 创建链表
     *
     * @param iterable 迭代接口
     * @return 创建的列表头节点
     */
    public static ListNode create(Iterable<Integer> iterable) {
        if (iterable == null) {
            return null;
        }
        return create(iterable.iterator(), -1);
    }

    /**
     * 打印列表
     *
     * @return 返回字符串
     */
    public String toListString() {
        if (this.hasRing) {
            throw new IllegalStateException("带环的列表无法调用此函数");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        ListNode current = this.next;
        while (current != null) {
            sb.append(ARROW);
            sb.append(current.val);
            current = current.next;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static void main(String[] args) {
        ListNode listNode = create(new int[]{1}, 0);
        System.out.println(listNode);
    }

}
