package DoublePointer;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/21 17:39
 *
 *
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水，返回容器可以储存的最大水量。
 *
 * 思路： 双指针从两侧向内侧移动，
 * 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 变短
 * 若向内 移动短板 ，水槽的短板 min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
 * 若向内 移动长板 ，水槽的短板 min(h[i],h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
 * 因此，初始化双指针分列水槽左右两端，循环每轮将短板向内移动一格，并更新面积最大值，直到两指针相遇时跳出；即可获得最大面积。
 * 如何两个板的高度相等，移动哪个都可以，结果是一样的
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int res=0, left=0,right=height.length-1;
        while(left<right){
            if(height[left]<height[right]){
                res= Math.max(res, (right-left)*Math.min(height[left],height[right]));
                left++;
            }else{
                res= Math.max(res, (right-left)*Math.min(height[left],height[right]));
                right--;
            }
        }
        return res;
    }
}
