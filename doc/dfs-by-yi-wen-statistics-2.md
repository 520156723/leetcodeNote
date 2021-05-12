## 方法1——深度优先搜索
打印出所有数，然后找到第二小的数。


### 代码

```python3
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        if not root.left and not root.right:
            return -1
        nums = []
        d = collections.deque()
        d.append(root)
        while d:
            n = len(d)
            for i in range(n):
                node = d.popleft()
                if node.left:
                    d.append(node.left)
                    d.append(node.right)
                nums.append(node.val)
        minums = min(nums)
        res = 2**31
        for i in nums:
            if i > minums:
                res = min(res, i)
        return res if res != 2**31 else -1
```

### 复杂度分析
时间复杂度：O(N)
空间复杂度：O(N)

### 代码优化
可以使用集合或者哈希进行值的存储

```
class Solution:
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        if not root.left and not root.right:
            return -1
        nums = set()
        d = collections.deque()
        d.append(root)
        while d:
            n = len(d)
            for i in range(n):
                node = d.popleft()
                if node.left:
                    d.append(node.left)
                    d.append(node.right)
                nums.add(node.val)
        minums = min(nums)
        nums.remove(minums)
        return min(nums) if len(nums) > 0 else -1
```
