//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 794 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dfs(i , j, used, board, 0, word, move))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int i, int j, boolean[][] used, char[][] board, int depth, String word, int[][] move) {
        if(depth == word.length())
            return true;
        if(checkBorder(i,j,board) && word.charAt(depth) == board[i][j] && !used[i][j]){
            used[i][j] = true;
            for (int k = 0; k < move.length; k++) {
                int newi = i + move[k][0], newj = j + move[k][1];
                if (dfs(newi, newj, used, board, depth + 1, word, move)) {
                    return true;
                }
            }
            used[i][j] = false;
        }
        return false;
    }

    boolean checkBorder(int i, int j, char[][] board){
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
