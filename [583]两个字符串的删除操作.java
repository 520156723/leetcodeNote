//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 182 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= m; i++) {
            int[] tmp = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    tmp[j] = i + j;
                }else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    tmp[j] = dp[j - 1];
                }else {
                    tmp[j] = Math.min(dp[j], tmp[j - 1]) + 1;
                }
            }
            dp = tmp;
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
