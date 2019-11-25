package RecursionClass;
/**
 * 题目：现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * 思路：
 *        方法一：循环方法（从下向上） 减少重复  双指针
 *        方法二：递归方法（从上向下） 重复较多
 *
 * 注意：
 *      f(n)=f(n-1)+f(n-2)   都可以这样做
 *      防止 int溢出 可以使用 long 类型
 *
 */

/**
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 *      求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路： 共有 f(n)=2^(n-1)
 */

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(new Fibonacci().Fibonacci(7));

    }
    //递归方法
    /*private int Fibonacci(int n) {
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }*/
    //循环方法
    private int Fibonacci(int n){
        int left=0,right=1,res=0;
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        for(int i=2;i<=n;i++){
            res=left+right;
            left=right;
            right=res;
        }
        return res;
    }

    private int RectCover(int target){
        int[] res={1,2};
        if(target>0&&target<=2)
            return res[target-1];
        int big=2;
        int small=1;
        int temp=0;
        for(int i=2;i<target;i++){
            temp=big+small;
            small=big;
            big=temp;
        }
        return temp;
    }


    private int JumpFloorII(int target) {
        int res=1;
        if(target<=0)
            return 0;
        for(int i=1;i<target;i++){
            res*=2;
        }
        return res;
    }
}
