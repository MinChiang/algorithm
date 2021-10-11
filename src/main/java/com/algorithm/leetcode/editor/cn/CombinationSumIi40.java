package com.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-09-24 16:55
 */
public class CombinationSumIi40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        List<Integer> selected = new ArrayList<>();
        dfs(candidates, selected, used, target, result, 0);
        return result;
    }

    public void dfs(int[] candidates, List<Integer> selected, boolean[] used, int rest, List<List<Integer>> result, int begin) {
        // 结束条件
        if (rest == 0) {
            result.add(new ArrayList<>(selected));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            // 选择
            if (used[i]) {
                continue;
            }
            if (candidates[i] > rest) {
                // 没有必要继续循环了，因为后续的元素都比当前的元素大
                return;
            }
            used[i] = true;
            selected.add(candidates[i]);
            // 继续递归
            dfs(candidates, selected, used, rest - candidates[i], result, i + 1);
            // 撤销选择
            used[i] = false;
            selected.remove(selected.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIi40 combinationSumIi40 = new CombinationSumIi40();
        System.out.println(combinationSumIi40.combinationSum2(new int[]{1,2,5}, 8));
    }

}
