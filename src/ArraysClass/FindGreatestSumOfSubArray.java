package ArraysClass;

/**
 *  题目：给一个数组，返回它的最大连续子序列的和
 *      例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 *  思路：两个变量 一个用于计算 一个用于存储结果 每次计算完通过三目运算符 判断结果
 *  注意： 数组中全是负数的情况
 */
public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] array={-3,-2,-15};
//        int[] array={6,-3,-2,7,-15,1,2,2};
        System.out.println(new FindGreatestSumOfSubArray().FindGreatestSumOfSubArray(array));
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0)
            return 0;
        int sum=0,res=Integer.MIN_VALUE;
        for (int value : array) {
            if (sum < 0)
                sum = 0;
            sum = sum + value;
            res = Math.max(sum, res);
        }
        return res;
    }
}
