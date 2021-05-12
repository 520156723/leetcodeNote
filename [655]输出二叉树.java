//在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则： 
//
// 
// 行数 m 应当等于给定二叉树的高度。 
// 列数 n 应当总是奇数。 
// 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。
// 根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分
//，右子树输出在右下部分。左下和右下部分应当有相同的大小。
// 即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，
// 但仍需要为另一个子树留出足够的空间。然而，
//如果两个子树都为空则不需要为它们留出任何空间。 
// 每个未使用的空间应包含一个空的字符串""。 
// 使用相同的规则输出子树。 
// 
//
// 示例 1: 
//
// 
//输入:
//     1
//    /
//   2
//输出:
//[["", "1", ""],
// ["2", "", ""]]
// 
//
// 示例 2: 
//
// 
//输入:
//     1
//    / \
//   2   3
//    \
//     4
//输出:
//[["", "", "", "1", "", "", ""],
// ["", "2", "", "", "", "3", ""],
// ["", "", "4", "", "", "", ""]]
// 
//
// 示例 3: 
//
// 
//输入:
//      1
//     / \
//    2   5
//   / 
//  3 
// / 
//4 
//输出:
//[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// 1-2-3-4
// 1-3-7-15  dp[i]=dp[i-1]*2+1
// 注意: 二叉树的高度在范围 [1, 10] 中。
// Related Topics 树 
// 👍 97 👎 0


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
    //先算出结果的行列，初始化后再深度遍历修改，每次修改的位置是局部中点
    public List<List<String>> printTree(TreeNode root) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        int row = getDepth(root);
        int col = (1 << row) - 1;//列数Ci = C(i-1) * 2 + 1 = 2^i - 1;
        for (int i = 0; i < row; i++) {
            ArrayList<String> path = new ArrayList<>();
            for (int j = 0; j < col; j++)
                path.add("");
            res.add(path);
        }
        modify(root, 0, res, 0, col - 1);
        return res;
    }

    void modify(TreeNode root, int depth, ArrayList<List<String>> res,
                    int l, int r) {
        if(root == null)
            return;
        int mid = l + (r - l >> 1);
        res.get(depth).set(mid, String.valueOf(root.val));
        modify(root.left,depth + 1,res,l,mid - 1);
        modify(root.right,depth + 1,res, mid + 1,r);
    }

    int getDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(getDepth(root.left),
                getDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
