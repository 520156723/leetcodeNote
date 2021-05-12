//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 977 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    //递归函数返回包括该树根结点的最大路径和，
    //题目所求的最大路径和可能不经过根结点，所以递归函数里需要更新全局最大值
    int max = -1001;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if(root == null)
            return -1001;//不能为0，因为结点值可能为负数
        int left = dfs(root.left);
        int right = dfs(root.right);
        //分为选一个结点和选两个结点的情况，不能三个都选，三个都选就不能连上父节点了
        int returnVal = Math.max(root.val, root.val + Math.max(left, right));
        //跟选三结点的情况比较
        max = Math.max(max, Math.max(returnVal, root.val + left + right));
        return returnVal;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
