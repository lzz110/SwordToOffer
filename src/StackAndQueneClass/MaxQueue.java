package StackAndQueneClass;

import java.util.*;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/8 21:52
 *
 * 剑指 59 队列的最大值
 *      需要使用 双向队列 ，假设队列已经有若干元素：
 *
 *      当执行入队 push_back() 时： 若入队一个比队列某些元素更大的数字， 则为了保持此列表递减，需要将双向队列 尾部所有小于 x 的元素 弹出。
 *      当执行出队 pop_front() 时： 若出队的元素是最大元素，则 双向队列 需要同时 将首元素出队 ，以保持队列和双向队列的元素一致性。
 *
 *  注意： 包装类型的比较，一定要使用 equals, 比如 用== 是不对的
 *  //if(queue.peek()==deque.peekFirst())
 *    if(queue.peek().equals(deque.peekFirst()))
 */
public class MaxQueue {





    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<Integer>();
        deque = new LinkedList<Integer>();
    }

    public int max_value() {
        if(deque.isEmpty()) return -1;
        return deque.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);
        while(!deque.isEmpty() && deque.getLast()<value){
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()) return -1;
        //if(queue.peek()==deque.peekFirst())
        if(queue.peek().equals(deque.peekFirst()))
            deque.pollFirst();
        return queue.poll();
    }

}
