package MathClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/9 19:33
 *
 *  题目： 剑指 Offer 62. 圆圈中最后剩下的数字
 *
 *
 *
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        int res =0;
        for(int i=2;i<=n;i++){
            res=(res+m)%i;
        }
        return res;
    }

}
