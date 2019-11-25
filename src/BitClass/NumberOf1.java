package BitClass;

/**
 *  题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 *  思路：
 *      方法一：标志位从后向前 逐位判断  如果从前向后 负数右移 补1 陷入死循环
 *      方法二：n=n&(n-1)  会把该整数最右边的 1变成 0
 */
public class NumberOf1 {
    public static void main(String[] args) {


//        int[] res=new int[256];
//        char ch='c';
//        res[ch]=1;
//        System.out.println((int)ch);
//        System.out.println(new NumberOf1().NumberOf1(-10));
    }

    //方法一
    private int NumberOf1(int n) {
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0){
                count++;
            }
            flag=flag<<1;
        }
        return count;
    }

    //方法二
    /*
    private int NumberOf1(int n){
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
    */


}
