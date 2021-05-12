//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2050 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //按列求，遍历列矮于 min=Min(左边最高墙， 右边最高墙）时，能接到水
    //遍历下标选择为 l,r指针对应的较矮方，这样更新最小值mid能确保是左右最高墙的较小值
    public int trap(int[] height) {
        int lMax = 0, rMax = 0, sum = 0;
        int l = 1, r = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[l - 1] < height[r + 1]) {
                lMax = Math.max(lMax, height[l - 1]);
                if (lMax > height[l])
                    sum += lMax - height[l];
                l++;
            }else {
                rMax = Math.max(rMax,height[r + 1]);
                if(rMax > height[r])
                    sum += rMax - height[r];
                r--;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
