package HeapClass;
/**
 * 题目：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * 思路：用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。
 *      重写compare  规定降序排列
 *
 * 注意：compare 默认是升序的
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Comparator;
public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] input={4,5,10,6,2,7,3,8};
        ArrayList<Integer> res=new GetLeastNumbers().GetLeastNumbers_Solution(input,4);
        Iterator<Integer> iterator = res.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        //构建优先队列，基于最大堆 重写compare  规定降序排列
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);    //正常是升序排列 o1.compareTo(o2) 现在将 o2 和o1 互换 变成降序
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);        //.offer()与.add()一样
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}

