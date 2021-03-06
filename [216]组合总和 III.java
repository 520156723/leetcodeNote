//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 275 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(1, k, n, new ArrayList<Integer>(), res);
        return res;
    }

    void backtrack(int begin, int k, int n, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        if (k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = begin; i < 10; i++) {
            if(n < 0)
                break;
            path.add(i);
            backtrack(i + 1, k - 1,n - i,path,res);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
