//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 457 👎 0

import java.util.ArrayList;
import java.util.List;

//     [1],
//     [1,1],
//     [1,2,1],
//     [1,3,3,1],
//     [1,4,6,4,1]
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> path = new ArrayList<>();
            if (i > 0) {
                List<Integer> pre = res.get(i - 1);
                for (int j = 0; j < pre.size(); j++) {
                    if (j == 0) {
                        path.add(1);
                    } else {
                        path.add(pre.get(j - 1) + pre.get(j));
                    }
                }
            }
            path.add(1);
            res.add(path);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
