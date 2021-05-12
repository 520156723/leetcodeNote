//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。 
//
// 示例 1： 
//
//        1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
// 
//
// 下面是两个重复的子树： 
//
//       2
//     /
//    4
// 
//
// 和 
//
//     4
// 
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。 
// Related Topics 树 
// 👍 251 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
    //树哈希，给每课树标记一个哈希值
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;
    }

    String dfs(TreeNode root) {
        if(root == null)
            return "@";
        StringBuilder sb = new StringBuilder(dfs(root.left));
        String key = sb.append(",").append(dfs(root.right)).append(",").append(root.val).toString();
        int val = map.getOrDefault(key,0) + 1;
        if(val == 2)
            res.add(root);
        map.put(key, val);
        return key;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
