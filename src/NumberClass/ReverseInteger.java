package NumberClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/21 11:42
 *
 *
 * leetcode 7 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 *
 * 思路
 * 当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
 * 当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7 是 2^31 - 1 的个位数
 * 从 ans * 10 + pop < MIN_VALUE 这个溢出条件来看
 * 当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
 * 当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8 是-2^31 的个位数
 *
 *
 */



public class ReverseInteger {

    public int reverse(int x) {
        int res= 0;
        while(x!=0){
           if(res>Integer.MAX_VALUE /10||res<Integer.MIN_VALUE /10){
               return 0;
           }
           int temp=x%10;
           x=x/10;
           res=res*10+temp;
        }
        return res;
    }

}
