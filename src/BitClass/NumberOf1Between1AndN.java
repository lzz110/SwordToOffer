package BitClass;
/**
 * 题目： 求出任意非负整数区间十进制中1出现的次数（从1 到 n 中1出现的次数） 如 13--6
 * 思路： 逐个数逐位比较
 */
public class NumberOf1Between1AndN {

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(14));
    }
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n==0)
            return 0;
        int res=1;
        if(n>=1&&n<10)
            return res;
        for (int i = 9; i <=n ; i++) {
            res+=NumberHas1Core(i);
        }
        return res;
    }

    private int NumberHas1Core(int i) {
        int res=0;
        while(i!=0){
            if(i%10==1)res++;
            i/=10;
        }
        return res;
    }
}
