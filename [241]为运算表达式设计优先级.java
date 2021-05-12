//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
// 。 
//
// 示例 1: 
//
// 输入: "2-1-1"
//输出: [0, 2]
//解释: 
//((2-1)-1) = 0 
//(2-(1-1)) = 2 
//
// 示例 2: 
//
// 输入: "2*3-4*5"
//输出: [-34, -14, -10, -10, 10]
//解释: 
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10 
// Related Topics 分治算法 
// 👍 340 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //分治
    //该问题转化为 对一个运算符，左右两边式子进行组合计算,该运算符最后算
    public List<Integer> diffWaysToCompute(String input) {
        return dfs(0, input.length() - 1, input.toCharArray());
    }

    List<Integer> dfs(int l, int r, char[] chars) {
        int num = 0, cur = l;
        ArrayList<Integer> res = new ArrayList<>();//计算出的结果值
        while (cur <= r && Character.isDigit(chars[cur])) {
            num = num * 10 + (chars[cur] - '0');
            cur++;
        }
        if (cur > r) {
            res.add(num);//全是数字
            return res;
        }
        for (int i = cur; i <= r; i++) {//每个运算符都能当最后一个
            if(Character.isDigit(chars[i]))
                continue;
            List<Integer> left = dfs(l, i - 1, chars);
            List<Integer> right = dfs(i + 1, r, chars);
            for (int lVal : left) {
                for (int rVal : right) {
                    int val = 0;
                    if(chars[i] == '+') val = lVal + rVal;
                    if(chars[i] == '-') val = lVal - rVal;
                    if(chars[i] == '*') val = lVal * rVal;
                    res.add(val);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
