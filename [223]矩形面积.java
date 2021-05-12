//在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。 
//
// 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
// 示例: 
//
// 输入: -3, 0, 3, 4,    0, -1, 9, 2
//输出: 45 
//
// 说明: 假设矩形面积不会超出 int 的范围。 
// Related Topics 数学 
// 👍 103 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //
    // ------C,D
    // |      |    G,H
    //A,B-----
    //    E,F
    //
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1=(C-A)*(D-B),area2=(G-E)*(H-F);
        if(C <= E || G <= A || D <= F || H <= B)
            return area1 + area2;
        //右上选较小值，左下选较大值
        int add = (Math.min(G, C) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        return area1 + area2 - add;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
