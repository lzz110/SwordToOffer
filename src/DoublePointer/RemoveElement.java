package DoublePointer;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/22 20:00
 *
 * 题目：
 *      给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val的元素，并返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *      元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 思路：
 *      双指针：  快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
 *              慢指针：指向更新 新数组下标的位置
 *
 *      核心代码：
 *             if (nums[fastIndex] != val) {
 *                 nums[slowIndex] = nums[fastIndex];
 *                 slowIndex++;
 *             }
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        //特判
        if(nums == null || nums.length<1) return 0;
        //双指针
        int slow =0, len = nums.length;
        for(int fast=0;fast< len;fast++){
            if(nums[fast]!=val){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }


    /**
     * 题目： 26. 删除有序数组中的重复项
     *
     * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
     *
     *  思路：
     *      双指针
     *          如果slow 和 fast 值不相等，slow 向后移动一位，并将fast 所指向的值 写在 slow 的位置上
     *          如果slow 和 fast 值相等  ，fast 向后移动一位， 继续寻找不同的值
     *
     */
    public int removeDuplicates(int[] nums) {
        //特判
        if(nums==null || nums.length<1) return 0;
        //双指针
        int slow= 0, len= nums.length;
        for(int fast=1;fast < len;fast++){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;
    }
}

