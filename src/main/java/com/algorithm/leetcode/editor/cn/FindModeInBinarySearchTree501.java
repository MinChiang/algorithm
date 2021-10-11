package com.algorithm.leetcode.editor.cn;

import com.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-09-28 10:25
 */
public class FindModeInBinarySearchTree501 {

    private static class Res {

        int lastVal;
        int lastCount;
        int resultCount;
        List<Integer> result;

        public Res(int lastVal, int lastCount, int resultCount, List<Integer> result) {
            this.lastVal = lastVal;
            this.lastCount = lastCount;
            this.resultCount = resultCount;
            this.result = result;
        }

    }

    public int[] findMode(TreeNode root) {
        Res res = new Res(0, 0, 0, new ArrayList<>());
        dfs(root, res);
        int[] ans = new int[res.result.size()];
        for (int i = 0; i < res.result.size(); i++) {
            ans[i] = res.result.get(i);
        }
        return ans;
    }

    private void dfs(TreeNode node, Res res) {
        if (node.left != null) {
            dfs(node.left, res);
        }

        if (node.val == res.lastVal) {
            res.lastCount = res.lastCount + 1;
        } else {
            res.lastVal = node.val;
            res.lastCount = 1;
        }

        if (res.result.isEmpty()) {
            res.result.add(node.val);
            res.resultCount = 1;
        } else {
            if (res.lastCount == res.resultCount) {
                res.result.add(node.val);
            } else if (res.lastCount > res.resultCount) {
                List<Integer> r = new ArrayList<>();
                r.add(node.val);
                res.result = r;
                res.resultCount = res.lastCount;
            }
        }

        if (node.right != null) {
            dfs(node.right, res);
        }
    }

    public static void main(String[] args) {
        FindModeInBinarySearchTree501 findModeInBinarySearchTree501 = new FindModeInBinarySearchTree501();
        int[] mode = findModeInBinarySearchTree501.findMode(TreeNode.create(new Integer[]{0,null,1,2}));
        System.out.println(Arrays.toString(mode));
    }

}
