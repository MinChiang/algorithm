//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "0"
//输出：0
//解释：没有字符映射到以 0 开头的数字。
//含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
//由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
// 
//
// 示例 4： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
// Related Topics 字符串 动态规划 👍 979 👎 0


package com.algorithm.leetcode.editor.cn;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-31 16:20:19
 */
public class DecodeWays91 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDecodings(String s) {
            // 设dp(i)为由前面下表0到i组成的数量，s(i)为对应第i个字母，问题转化为：求dp(s.length - 1)
            // 当s(i) == 0时，即当前字母为0，那么此0必定与前面的一个字母组成，此时有：dp(i) = dp(i - 2)
            // 当s(i) != 0时，分下面两种情况考虑
            // 若能够与前一个字母组成，则 dp(i) = dp(i - 1) + dp(i - 2)
            // 否则dp(i) = dp(i - 1)
            // 特别的，dp(0) = 1，dp(1) = 1，采用滚动数组进行解答
            if (s.charAt(0) == '0') {
                return 0;
            }
            int pre = 1, grand = 1, curr = 1;
            char pc = s.charAt(0), cc;
            for (int i = 1; i < s.length(); i++) {
                cc = s.charAt(i);
                if (cc == '0') {
                    if (pc == '1' || pc == '2') {
                        curr = grand;
                    } else {
                        return 0;
                    }
                } else {
                    if (pc == '1' || (pc == '2' && cc < '7')) {
                        // 前面是1，当前任何一个字母都能够组成
                        curr = pre + grand;
                    } else {
                        curr = pre;
                    }
                }
                pc = cc;
                grand = pre;
                pre = curr;
            }
            return curr;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {

        Solution solution = new DecodeWays91().new Solution();
        System.out.println(solution.numDecodings("12"));
    }

}