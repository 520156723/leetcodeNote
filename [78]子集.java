//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 示例 2：
//输入：nums = [0]
//输出：[[],[0]]
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1009 👎 0
import java.util.ArrayList;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    void backtrack(int depth, int[] nums, ArrayList<Integer> path, ArrayList<List<Integer>> res){
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        backtrack(depth + 1, nums, path, res);
        path.add(nums[depth]);
        backtrack(depth + 1, nums, path, res);
        path.remove(path.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
