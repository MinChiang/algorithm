package common;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-10 9:35
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    /**
     * 创建树
     *
     * @param arr 数组
     * @return 树头节点
     */
    public static TreeNode create(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(arr[0]);
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (index == arr.length) {
                break;
            }
            if (arr[index] != null) {
                poll.left = new TreeNode(arr[index]);
                queue.offer(poll.left);
            }
            index++;
            if (index == arr.length) {
                break;
            }
            if (arr[index] != null) {
                poll.right = new TreeNode(arr[index]);
                queue.offer(poll.right);
            }
            index++;
        }
        return head;
    }

    /**
     * 创建树
     *
     * @param list 列表
     * @return 树头节点
     */
    public static TreeNode create(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<Integer> iterator = list.iterator();
        TreeNode head = new TreeNode(iterator.next());
        Integer tmp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (!iterator.hasNext()) {
                break;
            }
            tmp = iterator.next();
            if (tmp != null) {
                poll.left = new TreeNode(tmp);
                queue.offer(poll.left);
            }
            if (!iterator.hasNext()) {
                break;
            }
            tmp = iterator.next();
            if (tmp != null) {
                poll.right = new TreeNode(tmp);
                queue.offer(poll.right);
            }
        }
        return head;
    }

    /**
     * 层序遍历打印树
     *
     * @return 树的字符串
     */
    public String toHierarchyString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sb.append(current.val);
                sb.append(' ');
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    //-1
    // |-2
    // | |-4
    // | | |-8
    // | |
    // | |-5
    // |
    // |-3
    //   |-6
    //   |
    //   |-7
    public String toTreeString() {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            sb.append('-');
            sb.append(current.val);
            int size = queue.size();
            for (int i = 0; i < size; i++) {

            }
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNode.create(new Integer[]{5, 2, 8, null, null, 3, 4, null, null, 1});
        TreeNode treeNode = TreeNode.create(Stream.of(5, 2, 8, null, null, 3, 4, null, null, 1).collect(Collectors.toList()));
        System.out.println(treeNode.toHierarchyString());
    }

}
