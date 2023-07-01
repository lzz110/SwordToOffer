package StringClass;

/**
 *  题目：不适用库函数 将字符串转换为整数 leetcode 第8题
 *
 *  思路： 先判断首位是否有符号位 之后  res=res*10+str.charAt(i)
 *
 *  注意：   res 要设置成 long 类型 如果是 int 型 res 超出会自动 变成 Integer.MIN_VALUE 或者 Integer.MAX_VALUE
 *          int 溢出 特殊考虑 2147483648 -2147483649 等
 *          计算完flag 后，需要index ++ 否则到后面 while 循环 就直接退出了
 *          计算 res 的时候不要忘记 乘以 flag 并且 字符需要减去 ‘0’
 */

public class StrToInt {
    public static void main(String[] args) {

//        int res=new StringClass.StrToInt().StringClass.StrToInt("1234123");
//        int res=new StringClass.StrToInt().StringClass.StrToInt("A");
//        int res=new StringClass.StrToInt().StringClass.StrToInt(null);
//        int res=new StringClass.StrToInt().StringClass.StrToInt("");
//        int res=new StringClass.StrToInt().StringClass.StrToInt("-123");
        int res=new StrToInt().myAtoi(" -42");
//        int res=new StringClass.StrToInt().StringClass.StrToInt("-2147483649");

        System.out.println(res);
//        System.out.println(invalid_input);
    }

    public int myAtoi(String s) {
        //特判
        if(s==null&&s.length()<1) return 0;
        int len= s.length();
        char[] charArray = s.toCharArray();
        int index=0,res=0 , flag=1;
        //过滤前导空格
        while(index<len && charArray[index] == ' '){
            index++;
        }
        //特判
        if(index == len) return 0;
        //检查符号
        if(charArray[index]=='-'||charArray[index]=='+'){
            flag = charArray[index]=='-'?-1:1;
            index++;
        }
        while(index<len){
            if(charArray[index]>'9'||charArray[index]<'0'){
                break;
            }
            if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && charArray[index] > '7' ){
                return Integer.MAX_VALUE;
            }
            if(res < Integer.MIN_VALUE/10 || res == Integer.MIN_VALUE/10 && charArray[index] > '8' ){
                return Integer.MIN_VALUE;
            }
            res=res*10 + flag* (charArray[index] - '0');
            index++;
        }
        return res;
    }

    public int myAtoiRight(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > 7)) {
//            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
//            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > 8 )) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }


    public int StrToInt(String str) {
        int flag=1;
        long res=0;
        if(str==null||str.length()==0)
            return 0;
        int i=0;
        if(str.charAt(0)=='-'||str.charAt(0)=='+'){
            flag=str.charAt(0)=='-'?flag=-1:1;
            i++;
        }
        for(;i<str.length();i++){
            if(isnumber(str.charAt(i))&&res>=Integer.MIN_VALUE&&res<=Integer.MAX_VALUE){
                res=res*10+str.charAt(i)-'0';
            }else{
                return 0;
            }
        }
        return (int)(flag*res>=Integer.MIN_VALUE&&flag*res<=Integer.MAX_VALUE?flag*res:0);


    }

    private boolean isnumber(char charAt) {
        if(charAt>='0'&&charAt<='9'){
            return true;
        }else{
            return false;
        }
    }

}
