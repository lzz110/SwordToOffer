package SortClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/9 13:06
 *
 * 剑指offer 11. 旋转数组的最小数字（二分法，清晰图解）
 *  给你一个可能存在 重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 *  例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 思路： 排序数组的查找问题首先考虑使用 二分法 解决，其可将 遍历法 的 线性级别 时间复杂度降低至 对数级别
 *
 *
 */
public class MinArray {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1; // m 一定在 左排序数组 中，即旋转点 x 一定在 [m+1,j] 闭区间内，因此执行i=m+1；
            else if (numbers[m] < numbers[j]) j = m;  // m 一定在 右排序数组 中，即旋转点 x 一定在 [i,m] 闭区间内，因此执行j=m；
            else j--; //无法判断m 在哪个排序数组中
        }
        return numbers[i];
    }


}
