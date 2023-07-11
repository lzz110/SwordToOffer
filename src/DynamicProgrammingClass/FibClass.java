package DynamicProgrammingClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/9 21:08
 *
 * 剑指 Offer 10- I. 斐波那契数列
 *
 * 题目： F(0) = 0,   F(1) = 1 ， F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *       答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 */
public class FibClass {


    /**
     * 如下是从i=0 开始计算，返回时应该返回 a 的值
     *
     */

    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }


    /**
     *
     * 如下是从i=2 开始计算，需要考虑i=0,1，2 的情况
     *
     * @param n
     * @return
     */
    /*
    public int fib(int n) {
        int a = 0, b = 1, sum=1;
        if(n<2) return n;
        if(n==2) return 1;
        for(int i = 2; i < n; i++){
            a = b;
            b = sum;
            sum = (a + b)%1000000007 ;
        }
        return sum;
    }*/

    /**
     *  题目：  剑指 Offer 10- II. 青蛙跳台阶问题
     *          一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     *     思路： 还是满足 F(N) = F(N - 1) + F(N - 2) 公式，所以可以用动态规划
     *
     *
     */

    public int numWays(int n) {
        int a=1,b=2,res=2;
        if(n==0) return 1;
        if(n<=2) return n;
        for(int i=2;i<n;i++){
            res=(a+b)%1000000007;
            a=b;
            b=res;
        }
        return res;
    }
}
