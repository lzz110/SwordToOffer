package DynamicProgrammingClass;

/**
 *  题目：
 *      长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 *      请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 *      例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *  思路：
 *      方法一： 动态规划
 *              1. 我们想要求长度为n的绳子剪掉后的最大乘积，可以从前面比n小的绳子转移而来
 *              2. 用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，也就是dp[i]表示长度为i的绳子剪成m段后的最大乘积，
 *                 初始化dp[2] = 1， 先把绳子剪掉第一段（长度为j），如果只剪掉长度为 1，对最后的乘积无任何增益，所以从长度为2开始剪，即 j=2
 *
 *              3. 剪了第一段后，剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；
 *                 如果剪的话长度乘积即为j * dp[i - j]。取两者最大值max(j * (i - j), j * dp[i - j])
 *
 *              4. 第一段长度j可以取的区间为[2,i)，对所有j不同的情况取最大值，因此最终dp[i]的转移方程为
 *                 dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j]))
 *
 *              5. 最后返回dp[n]即可
 *
 *
 *      方法二：
 *              创建一个结果数组 从前向后计算 因为对称原因 只需要计算一半
 *              注意for 循环中条件判断 有无== 问题
 *
 *      方法三： 贪心算法
 *
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println(new CutRope().cutRope(8));
    }
    //方法一
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i < n + 1; i++){
            for(int j = 2; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
    //方法二
    public int cutRope(int target) {
        if(target<2) {
            return 0;
        }
        if(target==2) {
            return 1;
        }
        if(target==3) {
            return 2;
        }
        int[] res=new int[target+1];
        res[1]=1;
        res[2]=2;
        res[3]=3;
        int max=0;
        for(int i=4;i<=target;i++){
            for(int j=1;j<=i/2;j++){
                int temp=res[j]*res[i-j];
                if(temp>max)
                    max=temp;
            }
            res[i]=max;
        }
        return res[target];
    }

    //方法三
    /*
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        long res=1;
        int p=(int)1e9+7;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3%p;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (int)(res*n%p);
    }
    */
}
