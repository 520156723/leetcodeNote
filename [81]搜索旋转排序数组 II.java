//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。 
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 
//
// 示例 1: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
// 
//
// 示例 2: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false 
//
// 进阶: 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 291 👎 0
//2, 5, 0, 0, 0, 1, 2
//2, 5, 6, 7, 8, 0, 1

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                l++;
            } else if (nums[l] < nums[mid]) {//左有序
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            } else if (nums[l] > nums[mid]) {//右有序
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
