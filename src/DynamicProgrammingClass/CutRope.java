package DynamicProgrammingClass;

/**
 *  题目：
 *      长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 *      请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 *      例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *  思路：
 *      创建一个结果数组 从前向后计算 因为对称原因 只需要计算一半
 *      注意for 循环中条件判断 有无== 问题
 *
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println(new CutRope().cutRope(8));
    }

    public int cutRope(int target) {
        if(target<2) {
            return 0;
        }
        if(target==2) {
            return 1;
        }
        if(target==3) {
            return 2;
        }
        int[] res=new int[target+1];
        res[1]=1;
        res[2]=2;
        res[3]=3;
        int max=0;
        for(int i=4;i<=target;i++){
            for(int j=1;j<=i/2;j++){
                int temp=res[j]*res[i-j];
                if(temp>max)
                    max=temp;
            }
            res[i]=max;
        }
        return res[target];
    }
}
