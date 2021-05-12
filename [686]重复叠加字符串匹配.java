//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，
// 如果不存在则返回 -1。
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//
// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 104 
// 1 <= b.length <= 104 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 133 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //不断地叠加a，判断b是否是a的字串，直到第二次a长度大于等于b长度停止（第二次也要判断）
    //判断子串用kmp优化
    public int repeatedStringMatch(String a, String b) {
        int alen = a.length(), blen = b.length();
        int n = blen / alen;
        if(blen % alen != 0)
            n++;//第一次a长度大于等于b
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a);
        }
        if(indexOf(sb.toString(), b) != -1)
            return n;
        if(indexOf(sb.append(a).toString(), b) != -1)
            return n + 1;
        return -1;
    }
    //KMP算法
    //如果s2是s1的子串，返回s1开始匹配下标；否则-1
    int indexOf(String s1, String s2) {

        int[] next = getnext(s2);
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }
            if(s1.charAt(i) == s2.charAt(j))
                j++;
            if(j == s2.length())
                return i - j + 1;
        }
        return -1;
    }
    //获得重启数组
    int[] getnext(String s2){
        int[] next = new int[s2.length()];
        for (int i = 1, j = 0; i < s2.length(); i++) {
            while (j > 0 && s2.charAt(i) != s2.charAt(j))
                j = next[j - 1];
            if(s2.charAt(i) == s2.charAt(j))
                j++;
            next[i] = j;
        }
        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
