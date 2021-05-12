//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树 
// 👍 778 👎 0


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
    //dfs从后往前算和，深度遍历的时候用一个数组记录走过的路径，每遍历到一个节点，都要结合前面路径判断是否有新结果
    //由于测试案例只有1000个节点，数组最大长度不超过1000
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return getCount(root, sum, new int[1000], 0);
    }

    //先序遍历
    int getCount(TreeNode root, int sum, int[] path, int endIndex) {
        if(root == null)
            return 0;
        int tmp = root.val, count = 0;
        if(tmp == sum)
            count++;
        for (int i = endIndex - 1; i >= 0; i--) {
            tmp += path[i];
            if(tmp == sum)
                count++;
        }
        path[endIndex] = root.val;
        return count + getCount(root.left, sum, path, endIndex + 1)
                + getCount(root.right, sum, path, endIndex + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
