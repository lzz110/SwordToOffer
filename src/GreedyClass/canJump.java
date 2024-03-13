package GreedyClass;

public class canJump {

    /**
     * 题目：leetcode 55. 跳跃游戏
     *
     * 思路：
     *      贪心思想
     *      其实跳几步无所谓，关键在于可跳的覆盖范围！不一定非要明确一次究竟跳几步，每次取最大的跳跃步数，这个就是可以跳跃的覆盖范围。
     *      这个范围内，别管是怎么跳的，反正一定可以跳过来。那么这个问题就转化为跳跃覆盖范围究竟可不可以覆盖到终点！
     *
     *      每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围
     *      如果 cover 大于等于了终点下标，直接 return true 就可以了
     *
     */

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
