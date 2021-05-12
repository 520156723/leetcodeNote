//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 267 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            if (i > 0) {
                int len = res.size();
                for (int j = len - 1; j > 0; j--) {
                    res.set(j , res.get(j) + res.get(j - 1));
                }
            }
            res.add(1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
