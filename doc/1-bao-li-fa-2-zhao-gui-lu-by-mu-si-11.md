### 解题思路
此处撰写解题思路

### 代码

```javascript
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
//暴力法
// var findSecondMinimumValue = function(root) {
//     const res=new Set();
//     const recursive=node=>{
//         if(!node) return;
//         res.add(node.val);
//         recursive(node.left);
//         recursive(node.right);
//     }
//     recursive(root);
//     return [...res].sort((a,b)=>a-b)[1]||-1;
// };
//方法 2 找规律
var findSecondMinimumValue = function(root) {
    if(!root) return -1;
    const recursive=(node,min)=>{
        if(!node) return -1;
        //根左右
        if(node.val>min) return node.val;
        //遍历左子树 
        const left=recursive(node.left,min);
        //遍历右子树
        const right=recursive(node.right,min);
        //没有左子树
        if(left===-1) return right;
        //没有右子树
        if(right===-1) return left;
        return Math.min(left,right);
    }
    return recursive(root,root.val);
};


```