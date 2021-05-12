//给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。 
//
// 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。 
//
// 如果有多种构造方法，请你返回任意一种。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [1,null,2,null,3,null,4,null,null]
//输出：[2,1,3,null,null,null,4]
//解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
//     1
//   n   2
//      n  3
//        n  4
//    2
//  1   3
//        4
// 提示：
//
// 
// 树节点的数目在 1 到 10^4 之间。 
// 树节点的值互不相同，且在 1 到 10^5 之间。 
// 
// Related Topics 二叉搜索树 
// 👍 56 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //通过中序序列建树
    ArrayList<Integer> inorder = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return buildTree(0, inorder.size() - 1);
    }

    TreeNode buildTree(int l, int r) {
        if (l > r)
            return null;
        int mid = l + (r - l >> 1);
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = buildTree(l, mid - 1);
        root.right = buildTree(mid + 1, r);
        return root;
    }

    public void getInorder(TreeNode root) {
        if(root == null)
            return;
        getInorder(root.left);
        inorder.add(root.val);
        getInorder(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
