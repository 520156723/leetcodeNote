//给定一个二叉树，返回所有从根节点到叶子节点的路径。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 
// Related Topics 树 深度优先搜索 
// 👍 463 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        dfs(root, new ArrayList<String>(),res);
        return res;
    }

    void dfs(TreeNode root, ArrayList<String> tmp, ArrayList<String> res) {
        if(root == null)
            return;
        ArrayList<String> list = new ArrayList<>(tmp);
        list.add(root.val + "");
        if (root.left == null && root.right == null) {
            res.add(String.join("->",list));
            return;
        }
        dfs(root.left, list, res);
        dfs(root.right, list, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
