//给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。 
//
// 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。 
//
// 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。 
//
// 
//
// 示例： 
//
// 输入: "aba", "cdc", "eae"
//输出: 3
// 
//
// 
//
// 提示： 
//
// 
// 所有给定的字符串长度不会超过 10 。 
// 给定字符串列表的长度将在 [2, 50 ] 之间。
// Related Topics 字符串 
// 👍 59 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //把每个字符串都与其他字符串比较，a是否是b的子序列，是->a不是特殊序列 退出循环，否->继续比较到结束
    //若全为否，则该字符串为特殊序列，更新最值
    public int findLUSlength(String[] strs) {
        int max = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if(i == j)
                    continue;
                if (isSub(strs[i], strs[j]))
                    break;
            }
            if(j == strs.length)
                max = Math.max(max, strs[i].length());
        }
        return max;
    }
    //s1是否是s2的子串
    boolean isSub(String s1, String s2) {
        int len = 0;
        for (int i = 0; i < s2.length() && len < s1.length(); i++) {
            if(s2.charAt(i) == s1.charAt(len))
                len++;
        }
        return len == s1.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
