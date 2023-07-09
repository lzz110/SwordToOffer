package MathClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/9 13:41
 *
 *
 *剑指offer  编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 *
 * 思路：
 *      方法一： 循环逐位判断： 如果 n&1 ==1  res++, 不等于和等于, n 都有右移一位 , 直到n==0
 *
 *      方法二： 循环逐位判断： 如果 n&n-1 ==1 res++; 不等于和等于, n 都有右移一位 , 直到n==0
 *              n&n-1 相当于 消去数字 n 最右边的 1
 */
public class HammingWeight {
    public static void main(String[] args) {
//        System.out.println(2&1);

        System.out.println(new HammingWeight().hammingWeight(00000000000000000000000000001011));

    }
    public int hammingWeight(int n) {
        int res= 0;

//        while(n!=0){
//            n=n&n-1;
//            res++;
//        }

        while(n!=0){
            if((n&1)==1){
                res++;

            }
            n>>>=1;
        }
        return res;
    }
}
