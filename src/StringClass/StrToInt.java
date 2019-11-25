package StringClass;

/**
 *  题目：不适用库函数 将字符串转换为整数
 *
 *  思路： 先判断首位是否有符号位 之后  res=res*10+str.charAt(i)
 *
 *  注意：   res 要设置成 long 类型 如果是 int 型 res 超出会自动 变成 Integer.MIN_VALUE 或者 Integer.MAX_VALUE
 *          int 溢出 特殊考虑 2147483648 -2147483649 等
 *
 */

public class StrToInt {
    public static void main(String[] args) {

//        int res=new StringClass.StrToInt().StringClass.StrToInt("1234123");
//        int res=new StringClass.StrToInt().StringClass.StrToInt("A");
//        int res=new StringClass.StrToInt().StringClass.StrToInt(null);
//        int res=new StringClass.StrToInt().StringClass.StrToInt("");
//        int res=new StringClass.StrToInt().StringClass.StrToInt("-123");
        int res=new StrToInt().StrToInt("2147483648");
//        int res=new StringClass.StrToInt().StringClass.StrToInt("-2147483649");

        System.out.println(res);
//        System.out.println(invalid_input);
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
