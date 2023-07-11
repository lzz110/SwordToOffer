package MathClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/9 15:52
 *
 *   剑指 Offer 65. 不用加减乘除做加法
 *
 *   题目一： 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *   思路： 无进位和 与 异或运算 规律相同，进位 和 与运算 规律相同（并需左移一位），while循环退出条件为进位b==0 时
 *
 *   剑指 Offer 64. 求1+2+…+n
 *
 *   题目二 ：求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *   思路：
 *          常见的逻辑运算符有三种，即 “与 && ”，“或 ∣∣ ”，“非 ! ” ；而其有重要的短路效应，如下所示：
 *      if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false
 *      if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
 *
 *      本题需要实现 “当 n=1 时终止递归” 的需求，可通过短路效应实现。
 *      n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
 */
public class AddWithLogiicalOperator {
    //题目一
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    //题目二
    int res = 0;
    public int sumNums(int n) {
        boolean x = (n > 1) && sumNums (n - 1) > 0 ;
        res += n;
        return res;

        
    }

}
