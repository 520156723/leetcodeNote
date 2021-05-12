//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树 
// 👍 464 👎 0


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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null)
            return true;
        if(s == null)
            return false;
        StringBuilder s1 = getS(s, new StringBuilder());
        StringBuilder t1 = getS(t, new StringBuilder());
        return s1.indexOf(t1.toString()) >= 0;
    }

    StringBuilder getS(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if(root.left == null)
            sb.append("lnull");
        else
            sb.append(getS(root.left, sb));
        if(root.right == null)
            sb.append("rnull");
        else
            sb.append(getS(root.right, sb));
        return sb;
    }

    boolean isSame(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null)
            return true;
        if(n1 == null || n2 == null)
            return false;
        if(n1.val != n2.val)
            return false;
        return isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
