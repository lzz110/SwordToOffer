package SlidingArrayClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/9 20:51
 *
 * 题目：
 * =======
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 思路：
 *      滑动窗口， 循环条件为 while(i<j)
 *      初始化时，因为是正数序列 ， 所以 i=1.j=2,sum =3
 *
 */
public class findContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        List<int []> res= new ArrayList<>();
        int i=1,j=2,sum=3;
        while(i<j){
            if(sum == target){
                int len=j-i+1;
                int[] temp = new int[len];
                for(int k=i;k<=j;k++){
                    temp[k-i]=k;
                }
                res.add(temp);
            }
            if(sum>=target){
                sum-=i;
                i=i+1;
            }else {
                j++;
                sum+=j;
            }
        }
        return res.toArray(new int[0][]);

    }
}
