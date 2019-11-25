package DoublePointer;

import java.util.Arrays;

/**
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *      所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 思路：双指针 从前找到第一个偶数 从该偶数往后找第一奇数 将[偶数,奇数-1]的数 向后移动一位 ，奇数放到偶数位置
 *      偶数+1 继续寻找
 * 注意：涉及到数组时，一定要在while循环中判断数组越界
 *       判断奇数和偶数  用     &0x01
 */
public class reOrderArray {
    public static void main(String[] args) {
        int[] a=new int[]{
          1,2,3,4,5
        };
        System.out.println(Arrays.toString(a));
        new reOrderArray().reOrderArray(a);
        System.out.println(Arrays.toString(a));
        System.out.println(3&0x01);
    }
    public void reOrderArray(int [] array) {
        if(array==null||array.length==0)
            return ;
        int len=array.length;
        int left=0,right=0;
        while(left<len){
            //left指向第一个偶数
            while(left<len&&!iseven(array[left])){
                left++;
            }
            //right指向left后的第一个奇数
            right=left+1;
            while(right<len&&iseven(array[right])){
                right++;
            }
            //为了保证奇数和偶数顺序 把left到right-1的右移一个，然后把right放到left上
            if(right<len){
                int temp=array[right];
                for(int i=right-1;i>=left;i--){
                    array[i+1]=array[i];
                }
                array[left++]=temp;
            }else{
                break;
            }
        }
    }
    private boolean iseven(int number){
        if((number&0x01)==1){
            return false;
        }else return true;
    }
}
