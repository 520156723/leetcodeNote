//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 字符串 
// 👍 267 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int[] stack = new int[len / 2 + 1];//数组代替栈
        int p = 0;//栈指针
        char oprator = '+';//存上一个运算符
        int num = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if(Character.isDigit(c))
                num = num * 10 + c - '0';
            //读到运算符或最后一位
            if (i == len - 1 || (!Character.isDigit(c) && c != ' ')) {
                switch (oprator) {//取上一个运算符
                    case '+' :
                        stack[p++] = num;
                        break;
                    case '-':
                        stack[p++] = -num;
                        break;
                    case '*':
                        stack[p - 1] *= num;
                        break;
                    case '/':
                        stack[p - 1] /= num;
                        break;
                    default:
                        break;
                }
                num = 0;//算完清零
                oprator = c;
            }
        }
        while (--p > 0) {
            stack[p - 1] += stack[p];
        }
        return stack[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
