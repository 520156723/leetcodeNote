//给定一个无重复元素的数组 candidates 和一个目标数 target ，
// 找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1162 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(0, target, candidates, new ArrayList<Integer>(), res);
        return res;
    }

    void backtrack(int begin, int target, int[] candidates, ArrayList<Integer> tmp, ArrayList<List<Integer>> res){
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            backtrack(i, target - candidates[i], candidates, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
