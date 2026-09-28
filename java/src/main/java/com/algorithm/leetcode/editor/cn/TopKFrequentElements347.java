//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 904 👎 0

package com.algorithm.leetcode.editor.cn;

import java.util.*;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-11-12 16:24:08
 */
public class TopKFrequentElements347 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Element implements Comparable<Element> {

            int element;
            int count;

            public Element(int element) {
                this.element = element;
                this.count = 0;
            }

            @Override
            public int compareTo(Element o) {
                return this.count - o.count;
            }

        }

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Element> map = new HashMap<>();
            for (int num : nums) {
                Element element = map.computeIfAbsent(num, Element::new);
                element.count++;
            }
            Queue<Element> queue = new PriorityQueue<>();
            for (Element value : map.values()) {
                queue.offer(value);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            int[] ints = queue.stream().mapToInt(ele -> ele.element).toArray();
            return ints;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new TopKFrequentElements347().new Solution();
        String s = Arrays.toString(solution.topKFrequent(new int[]{1, 1, 5, 5, 2, 2}, 2));
        System.out.println(s);
    }

}