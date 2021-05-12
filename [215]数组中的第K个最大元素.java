//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 923 👎 0


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums);//键小根堆，并排序
        return nums[k - 1];
    }

    void buildHeap(int[] nums) {
        /*//从倒数第二层开始向下调整
        for (int i = nums.length / 2 - 1; i >= 0; i--)//这步复杂度为O(n)
            shiftdown(nums, i, nums.length);
        //降序排序:把最后一个元素和第一个交换，向下调整第一个元素
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            shiftdown(nums, 0, i);
        }*/
        for (int i = nums.length / 2 - 1; i >= 0 ; i--)
            shiftdown(nums, i, nums.length);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums,0,i);
            shiftdown(nums,0,i);
        }
    }

    void shiftdown(int[] nums, int i, int len) {
        /*int tmp = nums[i];
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1*//*去较小的子节点*//*) {
            if (j + 1 < len && nums[j + 1] < nums[j])//j指向较小值
                j++;
            if (tmp*//*比较的是要调整的值*//* < nums[j])
                break;
            nums[i] = nums[j];
            i = j;
        }
        nums[i] = tmp;*/
        int tmp = nums[i];
        for (int j = i * 2 + 1; j < len; j = j * 2 + 1) {
            if(j + 1 < len && nums[j + 1] < nums[j])
                j++;
            if(tmp < nums[j])
                break;
            nums[i] = nums[j];
            i = j;
        }
        nums[i] = tmp;
    }

    void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
