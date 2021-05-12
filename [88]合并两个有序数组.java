//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，
// 这样它就有足够的空间保存来自 nums2 的元素。
// 示例 1：
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 777 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //从后往前遍历可以保证不覆盖需要比较的num1元素
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, p = m + n - 1; p >= 0 ; p--) {
            if (i < 0) {//num1比完了，把num2中的元素填入
                nums1[p] = nums2[j--];
            } else if (j < 0) {
                nums1[p] = nums1[i--];
            } else if (nums1[i] >= nums2[j]) {
                nums1[p] = nums1[i--];
            }else {
                nums1[p] = nums2[j--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
