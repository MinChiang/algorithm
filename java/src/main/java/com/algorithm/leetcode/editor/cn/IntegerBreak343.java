//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 👍 621 👎 0


package com.algorithm.leetcode.editor.cn;

import java.util.*;
import com.algorithm.leetcode.common.*;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-11-12 16:47:55
 */
public class IntegerBreak343 {

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        int a = n / 2;
        int b = n - a;
        return a * b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new IntegerBreak343().new Solution();
    }

}