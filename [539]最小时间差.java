//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 104 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 字符串 
// 👍 83 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        for (int i = 0; i < timePoints.size(); i++) {
            String s = timePoints.get(i);
            minutes[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3));
        }
        Arrays.sort(minutes);
        int min = 1440 - minutes[n - 1] + minutes[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, minutes[i] - minutes[i - 1]);
            if(min == 0)
                return 0;
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
