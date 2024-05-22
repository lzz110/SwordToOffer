package DoublePointer;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/23 10:21
 *
 *  209. 长度最小的子数组
 *  题目：
 *  给定一个含有 n 个正整数的数组和一个正整数 target 。 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *  思路： 双指针，滑动窗口
 *  窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
 *  窗口的起始：如果当前窗口的值 大于等于 s了，窗口就要向前移动了（也就是该缩小了）。
 *  窗口的结束：窗口的结束位置就是遍历数组的指针，窗口的起始位置设置为数组的起始位置就可以了。
 *
 *  注意： for 循环的变量 是窗口右节点的位置
 *
 *
 *
 */
public class MinSubArrayLen {
    public static void main(String[] args) {

        int target = 4;
        int[] nums = {1,4,4};
        int res = new MinSubArrayLen().minSubArrayLen(target, nums);
        System.out.println(res);
    }
    public int minSubArrayLen(int target, int[] nums) {
        //特判
        if(nums==null || nums.length<1){
            return 0;
        }
        int res=Integer.MAX_VALUE,len=nums.length,slow=0,sum=0;
        for (int fast = 0; fast < len; fast++) {
            sum+=nums[fast];
            while(sum>=target){
                res=Math.min(res,fast-slow+1);
                sum-=nums[slow];
                slow++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
