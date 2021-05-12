//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
// Related Topics 动态规划 
// 👍 359 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 0,1背包问题
    // dp(i, j) 表示使用 `i` 个 `0` 和 `j` 个 `1`，最多能得到的从字符数组中选择的字符串数目
    // 对每个物品（字符串） 都有选 和 不选 两个选择
    // 不选 dp[i][j]就是上一个状态的dp[i][j]
    // 选 dp[i][j]是上一个状态的dp[i'][j']: dp[i - 选该字符用掉的0空间][j - 用掉的1空间] + 1
    // 由于每次dp[i][j]更新时都要拿到上一个状态的dp[i'][j']做判断,(i' <= i、j' <= j),
    // 所以从后往前遍历可以防止dp[i'][j']在取值前被修改
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = getCount(str);
            //i、j表示使用`i` 个 `0` 和 `j` 个 `1`
            for (int i = m; i >= count[0]; i--) {//可用的0个数不能小于该字符串需要的0个数
                for (int j = n; j >= count[1]; j--) {//同上剪枝
                    dp[i][j] = Math.max(dp[i][j], dp[i - count[0]][j - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    //获取该字符的0、1个数
    int[] getCount(String str) {
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - '0']++;
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
