package StringClass;

import java.util.Arrays;

/**
 *  题目：不适用库函数 将字符串转换为整数 leetcode 第8题
 *
 *  思路： 先判断首位是否有符号位 之后  res=res*10+str.charAt(i)
 *
 *  注意：数组越界处理
 *  在每轮数字拼接前，判断 res 在此轮拼接后是否超过 2147483647，若超过则加上符号位直接返回
 *  判断依据： bndry = Integer.MAX_VALUE (2147483647)/10
 *
 *   if (res>bndry) 执行拼接 10×res≥2147483650 越界
 *   if (res=bndry && i>7 ) 执行拼接正负数 2147483648 或者 2147483649 都越界
 *
 */

public class StrToInt {
    public static void main(String[] args) {

//        int res=new StringClass.StrToInt().StringClass.StrToInt("1234123");
        int res=new StringClass.StrToInt().strToInt("9223372036854775808");
//        int res=new StringClass.StrToInt().StringClass.StrToInt(null);
//        int res=new StringClass.StrToInt().strToInt("");
//        int res=new StringClass.StrToInt().strToInt(" ");
//        int res=new StringClass.StrToInt().StringClass.StrToInt("-123");
//        int res=new StringClass.StrToInt().strToInt("-91283472332");
//        System.out.println(Arrays.toString(" ".trim().toCharArray()));
        System.out.println(res);
//        System.out.println(invalid_input);
    }

    public int strToInt(String str) {
        if(str==null||str.length()==0) return 0;
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++) {
            if(isnumber(c[j])) break;
            if(res > bndry || res == bndry && c[j] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }



    private boolean isnumber(char charAt) {
        if(charAt>='0'&&charAt<='9'){
            return true;
        }else{
            return false;
        }
    }

}
