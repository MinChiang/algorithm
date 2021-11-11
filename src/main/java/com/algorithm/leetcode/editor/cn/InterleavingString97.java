//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 567 👎 0

package com.algorithm.leetcode.editor.cn;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-27 20:05:14
 */
public class InterleavingString97 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isInterleave(String s1, String s2, String s3) {
            // 设dp(i,j)意义为，取s1的前i个字符，取s2的前j个字符，能否组成s3，取值范围为 0<=i<=s1.length,0<=j<=s2.length
            // dp(i,j) = (dp(i-1,j) && s1(i-1) == s3(i-1+j)) || (dp(i,j-1) && s2(j-1) == s3(i+j-1))
            // dp(0,0) = true
            // dp(0,j) = dp(0,j-1) && s2(j-1) == s3(j-1)
            // dp(i,0) = dp(i-1,0) && s1(i-1) == s3(i-1)
            if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
                return false;
            }
            if (s1.length() == 0) {
                return s2.equals(s3);
            }
            if (s2.length() == 0) {
                return s1.equals(s3);
            }
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            for (int i = 0; i < s1.length() + 1; i++) {
                for (int j = 0; j < s2.length() + 1; j++) {
                    if (i == 0 && j == 0) {
                        dp[0][0] = true;
                    } else if (i == 0) {
                        dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
                    } else if (j == 0) {
                        dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
                    } else {
                        dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i - 1 + j))) || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new InterleavingString97().new Solution();
        System.out.println(solution.isInterleave("aa", "ab", "abaa"));
    }

}