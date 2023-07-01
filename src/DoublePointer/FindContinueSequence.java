package DoublePointer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  题目：
 *      找出所有和为S的连续正数序列
 *  思路：
 *      方法一：双指针思想 用等差求和公式计算 sum
 *              if(sum>target) left++;
 *              if(sum<target) right++;
 *       方法二：只增减 left和 right 的值 不需要全部求和
 *              if(sum>target)  {sum=sum-left;left++;}
 *              if(sum<target)  {right++;sum=sum+right;}
 */
public class FindContinueSequence {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
        temp=new FindContinueSequence().FindContinuousSequence(100);
        Iterator<ArrayList<Integer>> it = temp.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }

    /*public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(sum<3)
            return res;
        int left=1,right=2;
        while(left<(sum+1)/2){      //至少要两个数    left<(sum+1)/2
            int temp=(right+left)*(right-left+1)/2;         //求left 到 right 的和
            if(temp==sum){
                ArrayList<Integer> singleres=new ArrayList<>();
                for (int i = left; i <=right ; i++) {
                    singleres.add(i);
                }
                res.add(singleres);
                left++;                      //关键  当前结果得到 进行下一次运算
            }else if(temp>sum){              //如果结果大于sum 右侧不动 减去左侧第一个数
                left++;
            }else{                           //如果结果小于sum 左侧不动 加上右侧第一个数
                right++;
            }
        }
        return res;
    }*/

   ////////// 剑指offer思路
   public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> listall = new ArrayList<ArrayList<Integer>>();
        if(sum < 3)
        {
            return listall; //因为至少要包括两个数，要求的是正整数序列，那么最小的和为3
        }
        int small = 1;//用来记录正整数序列中最小的数，
        int big = 2;//用来记录正整数序列中最大的数
        int mid = (sum + 1)/2;//序列之和为sum的数至少包括两个数，所以small<mid
        int cursum = small + big;//当前序列总和
        while(small < mid)
        {
            //当前的序列和大于sum
            while(cursum > sum && small < mid)      //注意while 还要判断 small<mid
            {
                cursum = cursum-small;
                small++;
            }
            //当前序列和为sum了，则将这些数加入到list中
            //注意相等的顺序要在大于之后，当大于减去small ==sum时候，需要加入结果，如果一直在上面就不会加上了
            if(cursum == sum)
            {
                ArrayList<Integer> listsum = new ArrayList<Integer>();
                for(int i=small;i<=big;i++)
                    listsum.add(i);
                listall.add(listsum);

            }
            //当前的序列和小于sum
            big++;
            cursum = cursum+big;

        }
        return listall;
    }

}
