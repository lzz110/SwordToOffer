package DynamicProgrammingClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/11 22:02
 *
 * 53. 最大子数组和
 * 题目： 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 思路： 动态规划
 * 动规五部曲如下：
 *
 *      1. 确定dp数组（dp table）以及下标的含义
 *              dp[i]：包括下标i（以nums[i]为结尾）的最大连续子序列和为dp[i]。
 *
 *      2. 确定递推公式
 *              dp[i]只有两个方向可以推出来：
 *
 *          dp[i - 1] + nums[i]，即：nums[i]加入当前连续子序列和
 *          nums[i]，即：从头开始计算当前连续子序列和
 *          一定是取最大的，所以dp[i] = max(dp[i - 1] + nums[i], nums[i]);
 *
 *      3.dp数组如何初始化
 *          从递推公式可以看出来dp[i]是依赖于dp[i - 1]的状态，dp[0]就是递推公式的基础。

 *      4.确定遍历顺序
 *          递推公式中dp[i]依赖于dp[i - 1]的状态，需要从前向后遍历。
 *
 *      5. 举例推导dp数组
 *
 */
public class MaxSubArray {



    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length ==0) return 0;
        int res=0,len=nums.length;
        int[] dp = new int[len];
        res=dp[0]=nums[0];
        for(int i=1;i<len;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            if(res<dp[i])res=dp[i];
        }
        return res;
    }

}
