//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 390 👎 0
import java.util.ArrayList;
import java.util.Arrays;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        backtrack(0, new ArrayList<Integer>());
        return res;
    }
    void backtrack(int depth, ArrayList<Integer> path) {
        if (path == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }



            if(path.size() > 0 || nums[i] != nums[i - 1]){
                backtrack(depth + 1, path);
            }
                continue;
            path.add(nums[depth]);
            backtrack(depth + 1, path);
            path.remove(path.size() - 1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
