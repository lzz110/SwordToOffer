package ArraysClass;

import java.util.Arrays;

/**
 * 题目：
 *      判断是否是 连续数组 0可以是任意数字
 * 思路：
 *      1、排序
 *      2、计算所有相邻数字间隔总数
 *      3、计算0的个数
 *      4、如果2、3相等，就是顺子
 *      5、如果出现对子，则不是顺子
 */
public class IsContinues {

    public static void main(String[] args) {
        int[] nums={3,1,0,4,6};
        boolean res = new IsContinues().isContinuous(nums);
        System.out.println(res);
    }
    public boolean isContinuous(int [] numbers) {
        if(numbers.length<5||numbers==null)
            return false;
        //排序
        Arrays.sort(numbers);
        //计算0的个数
        int len=numbers.length,numberofzero=0,numberofgap=0;
        for(int i=0;i<len;i++){
            if(numbers[i]==0){
                numberofzero++;
            }
        }
        //计算两数只差
        int left=numberofzero,right=left+1;
        while(right<len){
            //如果相等，直接返回false
            if(numbers[right]==numbers[left])
                return false;
            numberofgap+=numbers[right]-numbers[left]-1;
            left=right;
            right++;
        }
        return numberofgap>numberofzero?false:true;
    }
}
