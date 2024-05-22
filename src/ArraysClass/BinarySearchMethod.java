package ArraysClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/22 15:18
 *
 * 关于 边界值的确定，建议看视频：https://www.bilibili.com/video/BV1fA4y1o715/?vd_source=863a059723c7940f38655c3384b44639
 *  while() 中的 判断条件 需要结合 区间判断，可以想象 left 是否可以与 right 相等，如果可以就是<= , 否则就是 <  
 * 左闭右闭区间 [left, right] , while(left <= right) ，  left=mid+1; right=mid-1;
 * 左闭右开区间 [left, right) , while(left <  right) ，  left=mid+1; right=mid;
 *
 */
public class BinarySearchMethod {
    public static void main(String[] args) {
//        System.out.println(111);
//        int[] nums= {-1,0,3,5,9,12};
        int[] nums= {5,7,7,8,8,10};
        int target=5;
//        System.out.println(target>>1);
//        System.out.println(new BinarySearchMethod().searchInsert(nums,target));
        System.out.println(new BinarySearchMethod().isPerfectSquare(target));

    }

    public int binarySearch(int[] nums, int target) {
        int left=0, right= nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]> target){
                right = mid-1;
            }else if(nums[mid] < target){
                left= mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     *给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     * 思路：
     *      有序数字首选 二分查找，
     * 注意: 如果没有找到，返回left 就可以
     *
     * @param nums
     * @param target
     * @return
     */

    public int searchInsert(int[] nums, int target) {
        int left =0, right = nums.length-1;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right= mid-1;
            }else{
                left = mid +1;
            }
        }
        return left;
    }


    public int[] searchRange(int[] nums, int target) {
        int index= binarySearch(nums, target);
        if(index == -1) return new int[]{-1,-1};
        int left=index,right=index;
        while(left-1>=0 && nums[left-1]== target){
            left--;
        }
        while(right+1<nums.length && nums[right+1]== target){
            right++;
        }
        return new int[]{left,right};
    }

    /**
     *  leetcode 69 算数平方根
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     * 思路：
     *      二分查找， 左闭右开写法， left =1 , right = x/2 , middle < or > (target / middle)
     *      最后返回 right 的值 （多测试几个值就可以得出结论）
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        int left= 1, right = x/2, mid=0;
        while(left<=right){
            mid= left+(right-left)/2;
            if(mid<(x/mid)){
                left = mid+1;
            }else if(mid > (x/mid) ){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return right;
    }

    /**
     * 367. 有效的完全平方数
     * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
     * 不能使用任何内置的库函数，如  sqrt 。
     *
     * 思路： 用二分查找， 左闭右闭的区间，定义 long 类型的  long square = (long) mid * mid;
     *
     * 注意 要用 long 类型
     *
     * @param num
     * @return
     */

    public boolean isPerfectSquare(int num) {
        int left = 0, right = num/2;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }



}
