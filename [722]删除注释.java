//给一个 C++ 程序，删除程序中的注释。这个程序source是一个数组，其中source[i]表示第i行源码。 这表示每行源码由
//分隔。 
//
// 在 C++ 中有两种注释风格，行内注释和块注释。 
//
// 字符串// 表示行注释，表示//和其右侧的其余字符应该被忽略。 
//
// 字符串/* 表示一个块注释，它表示直到*/的下一个（非重叠）出现的所有字符都应该被忽略。（阅读顺序为从左到右）非重叠是指，字符串/*/并没有结束块注释，因
//为注释的结尾与开头相重叠。 
//
// 第一个有效注释优先于其他注释：如果字符串//出现在块注释中会被忽略。 同样，如果字符串/*出现在行或块注释中也会被忽略。 
//
// 如果一行在删除注释之后变为空字符串，那么不要输出该行。即，答案列表中的每个字符串都是非空的。 
//
// 样例中没有控制字符，单引号或双引号字符。比如，source = "string s = "/* Not a comment. */";" 不会出现在测试样
//例里。（此外，没有其他内容（如定义或宏）会干扰注释。） 
//
// 我们保证每一个块注释最终都会被闭合， 所以在行或块注释之外的/*总是开始新的注释。 
//
// 最后，隐式换行符可以通过块注释删除。 有关详细信息，请参阅下面的示例。 
//
// 从源代码中删除注释后，需要以相同的格式返回源代码。 
//
// 示例 1: 
//
// 
//输入: 
//source = ["/*Test program */", "int main()", "{ ", "  // variable declaration 
//", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "  
// testing */", "a = b + c;", "}"]
//
//示例代码可以编排成这样:
///*Test program */
//int main()
//{ 
//  // variable declaration 
//int a, b, c;
///* This is a test
//   multiline  
//   comment for 
//   testing */
//a = b + c;
//}
//
//输出: ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
//
//编排后:
//int main()
//{ 
//  
//int a, b, c;
//a = b + c;
//}
//
//解释: 
//第 1 行和第 6-9 行的字符串 /* 表示块注释。第 4 行的字符串 // 表示行注释。
// 
//
// 示例 2: 
//
// 
//输入: 
//source = ["a/*comment", "line", "more_comment*/b"]
//输出: ["ab"]
//解释: 原始的 source 字符串是 "a/*comment
//line
//more_comment*/b", 其中我们用粗体显示了换行符。删除注释后，隐含的换行符被删除，留下字符串 "ab" 用换行符分隔成数组时就是 ["ab"]
//.
// 
//
// 注意: 
//
// 
// source的长度范围为[1, 100]. 
// source[i]的长度范围为[0, 80]. 
// 每个块注释都会被闭合。 
// 给定的源码中不会有单引号、双引号或其他控制字符。 
// 
// Related Topics 字符串 
// 👍 53 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //分状态：在注释中和不在注释中，遍历每个字符串，不在注释中就天添加入临时字符串，最后加入结果集
    public List<String> removeComments(String[] source) {
        boolean inComment = false;
        ArrayList<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            if(!inComment)//不在注释中才创新结果
                sb = new StringBuilder();
            char[] chars = s.toCharArray();
            int i = 0, n = chars.length;
            while (i < n) {
                if (!inComment && i + 1 < n && chars[i] == '/' && chars[i + 1] == '*') {
                    inComment = true;
                    i++;
                } else if (inComment && i + 1 < n && chars[i] == '*' && chars[i + 1] == '/') {
                    inComment = false;
                    i++;
                } else if (!inComment && i + 1 < n && chars[i] == '/' && chars[i + 1] == '/') {
                    break;//后面的跳过，保持原有的状态
                } else if (!inComment) {
                    sb.append(chars[i]);
                }
                i++;
            }
            if(!inComment && sb.length() > 0)
                res.add(sb.toString());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
// 另一种写法
public static String removeComments(String s) {
        StringBuilder sb = new StringBuilder(s).append("\n");
        int i = 0;
        while (i < sb.length()){
            // 注释都以/开头
            int j = sb.indexOf("/", i);
            if(j == -1){
                // 没遇到注释起始符号退出
                break;
            }
            char c = sb.charAt(j + 1);
            if(c == '/'){
                // 行注释
                // 删除j位置到\n前的字符串，\n保留不删
                sb.delete(j, sb.indexOf("\n", j + 2));//sb最后一定要加\n不然这里是-1越界
                // 从j位置开始下一次遍历
                i = j;
            }else if(c == '*'){
                // 块注释
                // 删除j位置到*/的字符串，包括*/
                sb.delete(j, sb.indexOf("*/", j + 2) + 2);
                // 从j位置开始下一次遍历
                i = j;
            }else {
                // 跳过以/开头但是不是注释的情况
                // 例如：abc/def，应该从e字符开始下次遍历
                i = j + 2;
            }
        }
        return sb.toString();
    }
