//给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。 
//
// 假定 BST 有如下定义： 
//
// 
// 结点左子树中所含结点的值小于等于当前结点的值 
// 结点右子树中所含结点的值大于等于当前结点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 例如： 
//给定 BST [1,null,2,2], 
//
//    1
//    \
//     2
//    /
//   2
// 
//
// 返回[2]. 
//
// 提示：如果众数超过1个，不需考虑输出顺序 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 
// 👍 282 👎 0


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
    ArrayList<Integer> res = new ArrayList<>();
    int count, maxcount, base;
    public int[] findMode(TreeNode root) {
        dfs(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    void dfs(TreeNode root) {
        if(root == null)
            return;
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    void update(int num) {
        if (num == base) {
            count++;
        }else {
            base = num;
            count = 1;
        }
        if (count == maxcount) {
            res.add(num);
        }else if(count > maxcount){
            maxcount = count;
            res.clear();
            res.add(num);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
