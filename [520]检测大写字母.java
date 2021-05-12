//给定一个单词，你需要判断单词的大写使用是否正确。 
//
// 我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如"USA"。 
// 单词中所有字母都不是大写，比如"leetcode"。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。 
// 
//
// 否则，我们定义这个单词没有正确使用大写字母。 
//
// 示例 1: 
//
// 
//输入: "USA"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "FlaG"
//输出: False
// 
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。 
// Related Topics 字符串 
// 👍 125 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //10、00、11、01
    public boolean detectCapitalUse(String word) {
        boolean first = false, second = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < 'A' || (c > 'Z' && c < 'a') || c > 'z')
                return false;
            if (i == 0) {
                first = c >= 'A' && c <= 'Z';
            } else if (i == 1) {
                second = c >= 'A' && c <= 'Z';
                if(!first && second)
                    return false;
            } else {
                if ((first && !second) || (!first && !second)) {
                    if (c >= 'A' && c <= 'Z')
                        return false;
                } else if (first && second) {
                    if (c >= 'a' && c <= 'z') {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
