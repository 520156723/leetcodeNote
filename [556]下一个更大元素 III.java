//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 字符串 
// 👍 132 👎 0


import java.util.ArrayDeque;
import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int i = chars.length - 2, j = chars.length - 1;
        while (i >= 0 && chars[i] >= chars[i + 1])
            i--;
        if(i < 0)
            return -1;
        while (chars[j] <= chars[i])
            j--;
        swap(chars, i, j);
        reverse(chars, i + 1, chars.length - 1);
        try {
            return Integer.parseInt(new String(chars));
        } catch (Exception e) {
            return -1;
        }
    }

    void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars,i, j);
            i++;
            j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
