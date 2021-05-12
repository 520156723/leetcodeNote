//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 503 👎 0
import java.util.ArrayList;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<Integer>(), res);
        return res;
    }

    public void backtrack(int depth, int k, int n, ArrayList<Integer> path, ArrayList<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = depth; i <= n; i++) {
            if(i > n - (k - path.size()) + 1)//剪枝
                break;
            path.add(i);
            backtrack(i + 1, k, n, path, res);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
