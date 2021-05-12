//给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,5,9]
//              ,[10,11,13],
//               [12,13,15]], k = 8

//输出：13
//解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[-5]], k = 1
//输出：-5
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length 
// n == matrix[i].length 
// 1 <= n <= 300 
// -109 <= matrix[i][j] <= -109 
// 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列 
// 1 <= k <= n2 
// 
// Related Topics 堆 二分查找 
// 👍 552 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //二分，找猜测值的分割线，分割线左边都是不大于猜测值的，并统计这些个数与猜测值比较
    //初始从左下角开始统计 O(nlog(l-r)) n:边长 l最小值 r最大值
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = l + (r - l >> 1), count = 0;
            int i = n - 1, j = 0;
            while (i >= 0 && j < n){
                if(matrix[i][j] <= mid){
                    count += i + 1;
                    j++;
                }else{
                    i--;
                }
            }
            if (count >= k) {
                r = mid;
            } else{
                l = mid + 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
