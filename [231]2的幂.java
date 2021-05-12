//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 290 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // x & (-x) 保留x补码最后一个1.其余的置零
    //      7 = 00000111(7原码) -> 11111000 -> 11111001(-7补码)
    //     -7 = 11111001
    // 7 & -7 = 00000001
    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
