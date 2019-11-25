package OtherClass;

/**
 * 题目：
 *      请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *      "+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *      "12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 思路：  +-A[.[B]][e|EC]
 *      第一步：判断符号位             +-
 *      第二步：判断无符号位           A
 *      第三步：判断是否有小数位        .
 *      第四步：判断无符号位          [B]
 *      第五步：判断是否有指数         e|E
 *      第六步：判断符号位             +-
 *      第七步：判断无符号位           C
 *
 * 判断标准： 符号位如果有其他值 索引不会走到最后
 */

public class IsNumerical {
    public static void main(String[] args) {
//        String temp="100";
        String temp="3.141.5";
        char[] temptocharArray=temp.toCharArray();
        IsNumerical isnumerical=new IsNumerical();
        System.out.println(isnumerical.isNumeric(temptocharArray));
    }

    private int index=0;

    public  boolean isNumeric(char[] str) {

        if(str.length<1)
            return false;

        boolean flag=ScanInteger(str);

        //判断是否有小数
        if(index<str.length && str[index]=='.'){
            index++;
            flag=ScanUnsignedInteger(str);
            //flag = ScanUnsignedInteger(str) || flag;
        }
        //判断是否有指数
        if(index<str.length && (str[index]=='e'||str[index]=='E')){
            index++;
            flag = flag && ScanInteger(str);
        }
        return flag && index == str.length;
    }
    private boolean ScanInteger(char[] str){
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return ScanUnsignedInteger(str);
    }
    //判断 是否只有 无符号整数，如果中间有其他的index索引会停在 其他非整数位置 ，最后判断index是否指向末尾 会返回false
    private boolean ScanUnsignedInteger(char[] str) {
        int start=index;
        while(index<str.length&&(str[index]>='0' && str[index]<='9')){
            index++;
        }
        return start<index; //  如果有整数，则返回true 否则返回false
    }

}
