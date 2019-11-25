package ArraysClass;

import java.sql.RowIdLifetime;

/**
 * 题目：统计一个数字在排序数组中出现的次数。
 *
 * 思路：二分递归查找 确定 first k和 last k
 *
 * 注意：array[midindex]==k 条件判断
 *
 */
public class GetnumberOfK {
    public static void main(String[] args) {
//        int[] array={[1,2,3,3,3,3]};
        int[] array= {1,2,3,3,3,3};
        System.out.println(new GetnumberOfK().GetNumberOfK(array,3));
    }
    public int GetNumberOfK(int [] array , int k) {
        int res=0;
        int first=getfirstK(array,0, array.length-1,k);
        int last=getlastK(array,0,array.length-1,k);
        System.out.println("first="+first);
        System.out.println("last="+last);
        if(first!=-1&&last!=-1)
            res=last-first+1;
        return res;
    }
    private int getfirstK(int[] array,int left,int right,int k){
        if(left>right)
            return -1;
        int midindex=left+((right-left)>>1);
//        int midindex=left+(right-left)/2;
//        int midindex=(left+right)/2;
        if(array[midindex]==k){
            if((midindex>0&&array[midindex-1]!=k)||midindex==0){
                return midindex;
            }else right=midindex-1;
        }else if(array[midindex]>k){
            right=midindex-1;
        }else{
            left=midindex+1;
        }
        return getfirstK(array,left,right,k);
    }
    private int getlastK(int[] array,int left,int right,int k){
        if(left>right)
            return -1;
        int midindex=left+((right-left)>>1);
//        int midindex=left+(right-left)/2;
//        int midindex=(left+right)/2;
        if(array[midindex]>k){
            right=midindex-1;
        }else if(array[midindex]==k){
            if((midindex<array.length-1&&array[midindex+1]!=k)||midindex==array.length-1){
                return midindex;
            }else left=midindex+1;
        }else{
            left=midindex+1;
        }
        return getlastK(array,left,right,k);
    }
}
