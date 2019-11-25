package ArraysClass;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 题目：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *      输入 {2,3,4,2,6,2,5,1}，3  输出 {4,4,6,6,6,5}
 * 思路：方法一：两层for循环 外层控制起始窗口 内层控制滑动窗口
 *      方法二：使用数组双端队列
 *               对新来的元素k，将其与双端队列中的元素相比较
 *              1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
 *              2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 *              队列的第一个元素是滑动窗口中的最大值
 *
 */

public class MaxinWindows {
    public static void main(String[] args) {
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//        q.add(10);
//        q.add(20);
//        q.add(30);
//        System.out.println(q.peekFirst());
        int[] arr={2,3,4,2,6,2,5,1};
        ArrayList<Integer> res=new ArrayList<>();
        res=new MaxinWindows().maxInWindows(arr,3);

        System.out.println(res);
    }





    //常规方法 两个for 循环
/*    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res=new ArrayList<>();
        if(num==null||num.length==0||size==0||size>num.length)
            return res;
        for(int i=0;i<num.length-size+1;i++){
            int max=num[i];
            for(int j=i;j<size+i;j++){
                if(num[j]>max){
                    max=num[j];
                }
            }
            res.add(max);
        }
        return res;
    }*/

    //用数组队列 --双端队列 计算 队列中保存的是下标
    //对新来的元素k，将其与双端队列中的元素相比较
    //1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
    //2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
    //队列的第一个元素是滑动窗口中的最大值

    /*public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty())
                q.add(i);
                //当当前窗口移出队首元素所在的位置，即队首元素坐标对应的num不在窗口中，需要弹出
            else if (begin > q.peekFirst())
                q.pollFirst();
            //从后面依次弹出队列中比当前num值小的元素，同时也能保证队列首元素为当前窗口最大值下标
            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);   //把每次滑动的num下标加入队列
            if (begin >= 0)  //当滑动窗口首地址i大于等于size时才开始写入窗口最大值
                res.add(num[q.peekFirst()]);
        }
        return res;
    }*/
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res=new ArrayList<>();
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<num.length;i++){
            int begin=i-size+1;
            if(q.isEmpty()){
                q.add(i);
            }else{
                if(begin>q.peekFirst())
                    q.pollFirst();
            }
            while(q.size()!=0&&num[q.peekLast()]<=num[i]){
                q.pollLast();
            }
            q.add(i);
            if(begin>=0){
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }
}
