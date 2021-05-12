//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1140 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack( new boolean[nums.length], nums, new ArrayList<Integer>(), res);
        return res;
    }

    public void backtrack(boolean[] used, int[] nums, ArrayList<Integer> path, ArrayList<List<Integer>> res){
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i])
                continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(used,nums,path,res);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
