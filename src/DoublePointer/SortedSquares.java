package DoublePointer;

import java.util.Arrays;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/23 9:44
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] res=new  SortedSquares().sortedSquares(nums);
        System.out.println(Arrays.toString(res));

//        System.out.println(Math.abs(-7));
//        System.out.println(Math.abs(3));
//        System.out.println(Math.abs(-7)<Math.abs(3));
    }

    public int[] sortedSquares(int[] nums) {
        //特判
        if(nums == null || nums.length <1) return new int[]{0};
        int len = nums.length;
        int[] res = new int[len];
        int left=0,right=len-1,index=len-1;
        while(left<=right){
            if(Math.abs(nums[left])<Math.abs(nums[right])){
                res[index]=  nums[right] * nums[right];
                right--;
            }else{
                res[index]=  nums[left] *nums[left];
                left++;
            }
            index--;
        }
        return res;
    }
}
