//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 404 👎 0
import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //单调栈：要使栈中保留原数组元素的下标，存下标而不存值
    //环形数组可以逻辑上拉直，即取模拿值。 3，1，2->3，1，2，3，1
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);//提前为最后剩下的赋值
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!d.isEmpty() && nums[i % n] > nums[d.peekLast()])
                ans[d.pollLast()] = nums[i % n];
            d.addLast(i % n);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
