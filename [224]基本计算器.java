//实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// 
// Related Topics 栈 数学 
// 👍 363 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int i = 0;
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int oprator = '+';
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '(') {
                i++;
                num = calculate(s);
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')) {
                switch (oprator) {
                    case '+':
                        stack.addLast(num);
                        break;
                    case '-':
                        stack.addLast(-num);
                        break;
                    case '*':
                        stack.addLast(stack.removeLast() * num);
                        break;
                    case '/':
                        stack.addLast(stack.removeLast() / num);
                        break;
                }
                num = 0;
                oprator = c;
            }
            if(c == ')')
                break;
            i++;
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
