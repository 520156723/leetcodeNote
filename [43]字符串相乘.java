//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 568 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        String res = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            int add = 0;
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                tmp.append(0);
            }
            for (int j = num1.length() - 1; j >= 0 || add > 0; j--) {
                int n1 = j >= 0 ? num1.charAt(j) - '0' : 0;
                int sum = n1 * n2 + add;
                tmp.append(sum % 10);
                add = sum / 10;
            }
            res = addString(res, tmp.reverse().toString());
        }
        return res;
    }
    String addString(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int add = 0;
        StringBuilder tmp = new StringBuilder();
        for (int i = l1 - 1,j = l2 - 1; i >= 0 || j >= 0 || add > 0; i--, j--) {
            int n1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = n1 + n2 + add;
            add = sum / 10;
            tmp.append(sum % 10);
        }
        return tmp.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
