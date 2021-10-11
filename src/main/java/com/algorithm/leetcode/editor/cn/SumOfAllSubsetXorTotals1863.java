package com.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-06-08 10:04
 */
public class SumOfAllSubsetXorTotals1863 {

    // 0 1 2 3 4 5
    // 0 => {}
    // 1 => {0} {1} {2} {3} {4} {5}
    // 2 => {0,1} {0,2} {0,3} {0,4} {0,5} {1,2} {1,3} {1,4} {1,5} {2,3} {2,4} {2,5} {3,4} {3,5} {4,5}
    // 3 => {0,1,2} {0,1,3} {0,1,4} {0,1,5} {1,2,3} {1,2,4} {1,2,5} {1,3,4} {1,3,5} {2,3,4} {2,3,5} {3,4,5}
    // 4 => {0,1,2,3} {0,1,2,4} {0,1,2,5} {1,2,3,4} {1,2,3,5} {2,3,4,5}
    // 5 => {0,1,2,3,4,5} {1,2,3,4,5,6}
    // 6 => {0,1,2,3,4,5,6}
    public int subsetXORSum(int[] nums) {
        // 第一层表示要选择多少个元素
        int result = 0;
        for (int i = 0; i <= nums.length; i++) {
            result += backtrack(nums, i, 0, new ArrayList<>());
        }
        return result;
    }

    public int backtrack(int[] nums, int needToSelect, int beginIndex, List<Integer> list) {
        int result = 0;
        if (needToSelect == 0) {
            System.out.println(list);
            return calc(list);
        }
        // 第二层表示已经选择了多少个
        for (int j = beginIndex; j < nums.length; j++) {
            // 做选择
            list.add(nums[j]);
            // 回溯
            result += backtrack(nums, needToSelect - 1, j + 1, list);
            // 撤销选择
            list.remove(list.size() - 1);
        }
        return result;
    }

    private int calc(List<Integer> list) {
        return list.stream().reduce((a, b) -> a ^ b).orElse(0);
    }

    public static void main(String[] args) {
        SumOfAllSubsetXorTotals1863 sumOfAllSubsetXorTotals1863 = new SumOfAllSubsetXorTotals1863();
        System.out.println(sumOfAllSubsetXorTotals1863.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

}
