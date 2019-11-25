package RecursionClass;

/**
 * 题目一:
 *      一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 思路：
 *      将递归写成循环 减小重复
 *      从左往右算 类似双指针
 * 题目二：
 *     一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：
 *      数学归纳法 ： 2^(n-1)
 */

public class JumpFloor {
    public static void main(String[] args) {
        int res=new RecursionClass.JumpFloor().JumpFloor(5);
        //int res=new RecursionClass.JumpFloor().JumpFloorII(12);
        System.out.println(res);
    }
    public int JumpFloor(int target) {
        int[] result={1,2};
        if(target>=0&&target<2)
            return result[target];
        int low=1;
        int high=2;
        int temp=0;
        for(int i=2;i<target;i++){
            temp=low+high;
            low=high;
            high=temp;
        }
        return temp;
    }

    public int JumpFloorII(int target){
        if(target==0) return 0;
        int res=1;
        for(int i=1;i<target;i++){
            res=res<<1;
        }
        return res;
    }
}
