//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2]
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 数组 
// 👍 345 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //摩尔投票法：遇到相同的+1，否则-1
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        //最多两个候选人票数 > n/3
        int num1 = nums[0], count1 = 0;
        int num2 = nums[0], count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
                continue;
            }
            if (num == num2) {
                count2++;
                continue;
            }
            //num 既不是num1也不是num2时
            if (count1 == 0) {//换候选人
                num1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {//换候选人
                num2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        //找到两个众数
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;

        }
        if (count1 > nums.length / 3)
            res.add(num1);
        if (count2 > nums.length / 3)
            res.add(num2);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
