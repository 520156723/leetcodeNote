//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 343 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //"11"
    //"123"
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0 || n >= 0) {
            int n1 = m < 0 ? 0 : num1.charAt(m) - '0';
            int n2 = n < 0 ? 0 : num2.charAt(n) - '0';
            int sum = n1 + n2 + add;
            sb.append(sum % 10);
            add = sum / 10;
            m--;
            n--;
        }
        if(add > 0)
            sb.append(1);
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
