//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 565 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        int i1 = len1 - 1, i2 = len2 - 1;
        StringBuilder tmp = new StringBuilder();
        boolean add = false;
        while (i1 >= 0 || i2 >= 0) {
            char c1 = i1 >= 0 ? a.charAt(i1) : '0';
            char c2 = i2 >= 0 ? b.charAt(i2) : '0';
            if(add)
                c1 = c1 == '0' ? '1' : '0';
            if (c1 == c2) {
                tmp.append()
            }
            tmp.append()
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
