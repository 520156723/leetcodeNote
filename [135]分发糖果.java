//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 480 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length, res = 1;
        int dec = 0;//递减序列长度（不包括第一个）
        int inc = 1;//递增序列长度（包括第一个）
        int preNum = 1;//上一个孩子拿到的糖果
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                preNum++;
                res += preNum;
                dec = 0;
                inc = preNum;
            }else if(ratings[i] == ratings[i - 1]){
                preNum = 1;
                res += 1;
                dec= 0;
                inc = 1;
            }else {//遇到降序补发前面的
                dec++;
                if(dec == inc)
                    dec++;//增减长度相等，dec要包括第一个
                res += dec;
                preNum = 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
