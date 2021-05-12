//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 856 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // [5,7,7,8,8,10], target = 8
        int left = 0, right = nums.length - 1;
        int[] res = new int[]{-1, -1};
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] == target) {
                //找到下标
                res[0] = mid;
                res[1] = mid;
                int l = 0, r = mid - 1;
                while (l <= r) {
                    int lmid = l + (r - l >> 1);
                    if (nums[lmid] == target) {
                        r = lmid - 1;
                    }else {
                        l = lmid + 1;
                    }
                    res[0] = l;
                }
                l = mid + 1;
                r = nums.length - 1;
                while (l <= r) {
                    int rmid = l + (r - l >> 1);
                    if (nums[rmid] == target) {
                        l = rmid + 1;
                    }else {
                        r = rmid - 1;
                    }
                    res[1] = r;
                }
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
