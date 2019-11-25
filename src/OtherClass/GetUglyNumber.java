package OtherClass;

import java.util.ArrayList;
import java.util.Map;

/**
 * 题目：
 *      把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 *      习惯上把 1 当做是第一个丑数。
 *      求按从小到大的顺序的第N个丑数。
 * 思路：
 *      维护三个队列
 *                  乘以2的队列：2
 *                  乘以3的队列：3
 *                  乘以5的队列：5
 *      1.为什么分三个队列？
 *          丑数数组里的数一定是有序的，从丑数数组里的数乘以2,3,5选出的最小数，一定比以前未乘以2,3,5大，
 *          同时对于三个队列内部，按先后顺序乘以2,3,5分别放入，所以同一个队列内部也是有序的；
 *      2.为什么比较三个队列头部最小的数放入丑数数组？
 *          因为三个队列是有序的，所以取出三个头中最小的，等同于找到了三个队列所有数中最小的。
 * 优化：
 *      我们没有必要维护三个队列，只需要记录三个指针显示到达哪一步；
 */
public class GetUglyNumber {
    public static void main(String[] args) {
        System.out.println(new GetUglyNumber().GetUglyNumber_Solution(10));
    }
    public int GetUglyNumber_Solution(int index) {
        if(index>=0&&index<7) return index;
        ArrayList<Integer> res=new ArrayList<>();
        int p2=0,p3=0,p5=0;
        res.add(1);
        while(res.size()<index){
            int m2=res.get(p2)*2;
            int m3=res.get(p3)*3;
            int m5=res.get(p5)*5;
            int min= Math.min(m2,Math.min(m3,m5));
            if(min==m2) p2++;
            if(min==m3) p3++;
            if(min==m5) p5++;
            res.add(min);
        }
        return res.get(res.size()-1);
    }


}
