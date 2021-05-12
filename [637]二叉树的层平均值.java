//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 247 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Double> sum = new ArrayList<>();
    ArrayList<Integer> count = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        dfs(root, 1);
        for (int i = 0; i < count.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    void dfs(TreeNode root, int depth) {
        if(root == null)
            return;
        if (depth > sum.size()) {
            sum.add(1.0 * root.val);
            count.add(1);
        }else {
            sum.set(depth - 1, sum.get(depth - 1) + root.val);
            count.set(depth - 1, count.get(depth - 1) + 1);
        }
        dfs(root.left,depth + 1);
        dfs(root.right,depth + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
