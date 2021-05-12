//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map 
// 👍 301 👎 0


import java.util.TreeSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();//自然排序
        for (int i = 0; i < nums.length; ++i) {
            Long s = set.ceiling((long)nums[i]);//从set中找到第一个大于等于num[i]的元素
            if (s != null && s - nums[i] <= t)
                return true;
            Long g = set.floor((long)nums[i]);//从set中找到第一个小于等于num[i]的元素
            if (g != null && nums[i] - g <= t)
                return true;
            set.add((long)nums[i]);
            if (set.size() > k)
                set.remove((long)nums[i - k]);
        }
        return false;

    }


    /*private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            // check if bucket m is empty, each bucket may contain at most one element
            if (d.containsKey(m))
                return true;
            // check the nei***or buckets for almost duplicate
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            // now bucket m is empty and no almost duplicate in nei***or buckets
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
