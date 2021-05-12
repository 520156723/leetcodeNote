//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 958 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //3  4  -1  1
    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0)
                nums[i] = n + 1;
        }
        //3  4  5  1
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]);
            if(index > n)
                continue;
            nums[index - 1] = -Math.abs(nums[index - 1]);
        }
        //-3 4 -5 -1 （缺2）
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
