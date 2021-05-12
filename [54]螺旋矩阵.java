//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 611 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
// 1 2 3 4
// 5 6 7 8 tb
// 9 0 1 2
//   l r
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = n - 1, t = 0, b = m - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (l <= r && t <= b) {//第二趟可能会出现 l <= r 但 t > b ，第一个for里的matrix[t]会越界
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            for (int i = t + 1; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            if (t < b) {//反例：matrix只有一行的情况
                for (int i = r - 1; i >= l; i--) {
                    res.add(matrix[b][i]);
                }
            }
            if(l < r){//反例：matrix只有一列的情况
                for (int i = b - 1; i > t; i--) {
                    res.add(matrix[i][l]);
                }
            }
            l++;
            r--;
            t++;
            b--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
