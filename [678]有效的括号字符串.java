//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。
// 有效字符串具有如下规则：
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 字符串 
// 👍 219 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        LinkedList<Integer> stack1 = new LinkedList<Integer>();//记'('索引
        LinkedList<Integer> stack2 = new LinkedList<Integer>();//记'*'索引
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack1.addLast(i);
            } else if (c == '*'){
                stack2.addLast(i);
            } else if (c == ')') {
                if (!stack1.isEmpty()) {//先用'('栈
                    stack1.removeLast();
                }else if(!stack2.isEmpty()){//后用'*'栈
                    stack2.removeLast();
                }else {
                    return false;
                }
            }
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.removeLast() > stack2.removeLast())
                return false;
        }
        return stack1.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
