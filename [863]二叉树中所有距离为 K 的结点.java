//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。 
//
// 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。 
//           3
//        5    1
//      6  2  0  8
//        7 4
// 
// 
//
// 示例 1： 
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//输出：[7,4,1]
//解释：
//所求结点为与目标结点（值为 5）距离为 2 的结点，
//值分别为 7，4，以及 1
//
//
//
//注意，输入的 "root" 和 "target" 实际上是树上的结点。
//上面的输入仅仅是对这些对象进行了序列化描述。
//
//
// 提示： 
//
// 
// 给定的树是非空的。 
// 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。 
// 目标结点 target 是树上的结点。 
// 0 <= K <= 1000. 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 261 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    HashMap<TreeNode, TreeNode> child2parent = new HashMap<TreeNode, TreeNode>();
    HashSet<TreeNode> set = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        putMap(root, null);
        dfs(target, K);
        return res;
    }

    void dfs(TreeNode target, int k) {
        if (target == null || set.contains(target) || k < 0)
            return;
        set.add(target);
        if (k == 0) {
            res.add(target.val);
            return;
        }
        dfs(target.left, k - 1);
        dfs(target.right, k - 1);
        dfs(child2parent.get(target), k - 1);
    }

    void putMap(TreeNode child, TreeNode parent) {
        if (child == null)
            return;
        child2parent.put(child, parent);
        putMap(child.left, child);
        putMap(child.right, child);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
