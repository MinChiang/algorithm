//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。 
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例： 
//
// 输入:
//letters = ["c", "f", "j"]
//target = "a"
//输出: "c"
//
//输入:
//letters = ["c", "f", "j"]
//target = "c"
//输出: "f"
//
//输入:
//letters = ["c", "f", "j"]
//target = "d"
//输出: "f"
//
//输入:
//letters = ["c", "f", "j"]
//target = "g"
//输出: "j"
//
//输入:
//letters = ["c", "f", "j"]
//target = "j"
//输出: "c"
//
//输入:
//letters = ["c", "f", "j"]
//target = "k"
//输出: "c"
// 
//
// 
//
// 提示： 
//
// 
// letters长度范围在[2, 10000]区间内。 
// letters 仅由小写字母组成，最少包含两个不同的字母。 
// 目标字母target 是一个小写字母。 
// 
// Related Topics 数组 二分查找 👍 129 👎 0

package com.algorithm.leetcode.editor.cn;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-28 19:56:42
 */
public class FindSmallestLetterGreaterThanTarget744 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0, right = letters.length - 1, mid;
            while (left < right) {
                mid = (right - left) / 2 + left;
                // 目标比当前字母还要大
                if (target >= letters[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return letters[left] > target ? letters[left] : letters[0];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget744().new Solution();
        System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }

}