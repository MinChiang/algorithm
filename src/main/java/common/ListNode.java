package common;

import java.util.Iterator;
import java.util.List;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-09 15:57
 */
public class ListNode {

    public static final String ARROW = " -> ";
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 创建链表
     *
     * @param arr 数组
     * @return 创建的列表头节点
     */
    public static ListNode create(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode current = new ListNode(arr[0]), pre = current, root = current;
        for (int i = 1; i < arr.length; i++) {
            current = new ListNode(arr[i]);
            pre.next = current;
            pre = current;
        }
        return root;
    }

    /**
     * 创建链表
     *
     * @param list 元素列表
     * @return 创建的列表头节点
     */
    public static ListNode create(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<Integer> iterator = list.iterator();
        ListNode current = new ListNode(iterator.next()), pre = current, root = current;
        while (iterator.hasNext()) {
            current = new ListNode(iterator.next());
            pre.next = current;
            pre = current;
        }
        return root;
    }

    public String toListString() {
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

}
