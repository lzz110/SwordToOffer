package MathClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/9 15:52
 *
 * 剑指 Offer 65. 不用加减乘除做加法
 *
 *  题目： 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *  思路： 无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位），while循环退出条件为进位b==0 时
 */
public class AddWithLogiicalOperator {

    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }



}
