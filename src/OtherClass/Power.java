package OtherClass;

/**
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *      保证base和exponent不同时为0
 * 思路：考虑到  exponent 为负数和0的情况  求数值的整数次方 用快速幂
 */
public class Power {
    public static void main(String[] args) {
//        System.out.println(power(2,-2));
//        System.out.println(11&0x1);
        System.out.println(new Power().Power(0,-2));
    }
    //快速幂做法
    public double Power(double base, int exponent) {
        double res=1;int n=exponent;
        if(exponent<0){
            exponent=-exponent;
        }else if(exponent==0){
            return 1;
        }
        //quick
        while(exponent!=0){
            //如果是奇数 先乘一个base
            if((exponent&1)!=0){
                res*=base;
            }
            exponent>>=1;
            base*=base;
        }
        return  n>0?res:(1/res);
    }


    public double power(double base, int exponent){
        if((0.0==base)&&(exponent<0))
            return 0.0;
        double res=1;
        int flag=0;
        if(exponent<0) {
            flag=1;
            exponent*=-1;
        }
        for(int i=0;i<exponent;i++){
            res=res*base;
        }
        return flag==1?(1.0/res):res;
    }

}
