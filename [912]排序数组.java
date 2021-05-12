//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 272 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    void quickSort(int[] nums, int l, int r) {
        if(l > r)
            return;
        int index = getIndex(nums, l, r);
        quickSort(nums, l, index - 1);
        quickSort(nums, index + 1, r);
    }

    int getIndex(int[] nums, int l, int r) {
        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= tmp)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= tmp)
                l++;
            nums[r] = nums[l];
    }
        nums[l] = tmp;
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
