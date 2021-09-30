import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-09-28 17:18
 */
public class Test {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Deque<Integer> selected = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, selected, 0, targetSum, result);
        return result;
    }

    private void dfs(TreeNode node, Deque<Integer> selected, int currentSum, int targetSum, List<List<Integer>> result) {
        if (node.left == null && node.right == null && currentSum + node.val == targetSum) {
            List<Integer> tmp = new ArrayList<>(selected);
            tmp.add(node.val);
            result.add(tmp);
            return;
        }
        selected.offer(node.val);
        if (node.left != null) {
            dfs(node.left, selected, currentSum + node.val, targetSum, result);
        }
        if (node.right != null) {
            dfs(node.right, selected, currentSum + node.val, targetSum, result);
        }
        selected.pollLast();
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Test().pathSum(TreeNode.create(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
        System.out.println(lists);
    }

}
