//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 964 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        //以i结尾的最大、最小乘积子数组
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //这里最后需要跟nums[i]比较， 如num = 【0， 1】的结果是 1
            int tmpmax = max, tmpmin = min;
            max = Math.max(nums[i], Math.max(tmpmax * nums[i], tmpmin * nums[i]));
            min = Math.min(nums[i], Math.min(tmpmax * nums[i], tmpmin * nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
