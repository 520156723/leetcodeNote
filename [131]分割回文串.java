//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
// a ab
// aab
// a a b
// aa b
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 498 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        ArrayList<List<String>> res = new ArrayList<List<String>>();
        backtrack(0, s.toCharArray(), new ArrayList<String>(), res);
        return res;
    }

    void backtrack(int begin, char[] chars, ArrayList<String> path, ArrayList<List<String>> res) {
        if (begin == chars.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < chars.length; i++) {
            if (!check(chars, begin, i)) {//切出来的是否是回文
                continue;
            }
            //是回文串,继续切剩余字符
            path.add(new String(chars, begin, i - begin + 1));
            backtrack(i + 1,chars,path, res);
            path.remove(path.size() - 1);
        }
    }

    boolean check(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
