思路：一个结点如果存在子树，左右子树要么值相等，要么不相等
    不相等：在当前树中，较小的值和节点的值一样，第二小的必然是更大的那个。所以我们将返回结果res设置为该较大的值，因为较大的值在他的子树中一定是最小的值了，所以对较小值的树进行递归查找，是否会有更小的第二小的值（此处有点绕需要理解）
    若相等：分别递归左右子树
```
int res = -1;
public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
        return res;
    }
    //如果存在子树并且值不相等，那么较大的值就有可能是第二小的
    if (root.left != null && root.left.val != root.right.val) {
        //获取左右子树中将较大的值
        int bigger = root.left.val > root.right.val ? root.left.val : root.right.val;
        //如果返回值没有被更改过，则bigger有可能就是第二小的，如果返回值被更改过，则比较当前的res和bigger哪个更小
        res = res == -1 ? bigger:Math.min(res, bigger);
        //将左右子树中值更小的树进行递归，查找是否有更小的值（即为了上一步判断）
        findSecondMinimumValue(root.left.val > root.right.val ? root.right : root.left);
    }
    //如果左右子树相等或为空，分别递归
    else{
        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
    }
    return min;
}
```
