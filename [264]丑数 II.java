//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是质因数只包含 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划 
// 👍 478 👎 0
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //每个丑数都可以生成3个丑数，最原始的丑数是1，dp[0]=1
    //一旦某个丑数生成了*i(2、3、5)对应的新丑数，该丑数就失去了再乘以i的资格。即pi++
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int ugly = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            dp[i] = ugly;
            if(ugly == dp[p2] * 2) p2++;
            if(ugly == dp[p3] * 3) p3++;
            if(ugly == dp[p5] * 5) p5++;
        }
        return dp[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
