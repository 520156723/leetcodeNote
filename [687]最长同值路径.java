//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。 
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。 
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 递归 
// 👍 437 👎 0


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
//   1
//    1
//  1   1
//1  1 1
class Solution {
    int longest = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longest;
    }

    int dfs(TreeNode root) {
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int l = 0, r = 0;
        if (root.left != null && root.val == root.left.val)
            l = left + 1;
        if (root.right != null && root.val == root.right.val)
            r = right + 1;
        longest = Math.max(longest, l + r);
        return Math.max(l, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
