//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 字典树 记忆化搜索 哈希表 字符串 动态规划 👍 1221 👎 0

package com.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-10-28 20:26:50
 */
public class WordBreak139 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            return dfs(s, 0, set);
        }

        private boolean dfs(String s, int begin, Set<String> set) {
            if (s.length() == begin) {
                return true;
            }
            StringBuilder str = new StringBuilder();
            for (int i = begin; i < s.length(); i++) {
                str.append(s.charAt(i));
                if (set.contains(str.toString()) && dfs(s, i + 1, set)) {
                    return true;
                }
            }
            return false;
        }

        public boolean wordBreak2(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new WordBreak139().new Solution();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("aa");
        strings.add("aaa");
        strings.add("aaaa");
        strings.add("aaaaa");
        strings.add("aaaaaa");
        strings.add("aaaaaaa");
        strings.add("aaaaaaaa");
        strings.add("aaaaaaaaa");
        strings.add("aaaaaaaaaa");
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", strings));
    }

}