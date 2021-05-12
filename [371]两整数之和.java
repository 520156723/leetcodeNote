//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 381 👎 0


// 2 + 3 = 5
// 0010 + 0011 = 0101
//   0010     0010  a
//&  0011    ^0011  b
//<<
//---------  --------
//   0100 b'  0001  a'
//           ^0100  b'
//            0101  a''
// & 0001 a'
// <<
//   0000 b''

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int tmp = a ^ b;
            b = (a & b) << 1;
            a = tmp;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
