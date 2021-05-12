### 解题思路
根据题目中所给条件，根节点root的值一定是最小值。求大于roo.val的最小值即可。
注意一个测试用例：[2,2,2147483647]  2147483647是Integer的最大值。
### 代码

```java
class Solution {
    public long second_min = Long.MAX_VALUE;   //直接用long

    public int findSecondMinimumValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        long x = Long.MAX_VALUE;
        second_min = getMin(root,root.val,x);
        return (int)(second_min==Long.MAX_VALUE?-1:second_min);
    }

    //求大于num的最小值
    public long getMin(TreeNode root,long num,long cur){
        if (root != null) {
            if(root.val>num){
                cur = Math.min(cur,root.val);
            }
            return Math.min(getMin(root.left, num, cur),getMin(root.right, num, cur));
        }
        return cur;
    }
}
```
![image.png](https://pic.leetcode-cn.com/1604804669-JYrvKy-image.png)
