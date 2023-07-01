package StackAndQueneClass;


import java.util.Stack;

/**
 * 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思路：弹出操作时，先判断栈2有没有元素，有的话直接弹出
 *      没有从 栈1 中拿出所有元素 放在栈2，并弹出
 *      要考虑栈为空的情况
 */
public class TwoStackImplemtQueen {

    /** Initialize your data structure here. */
    class MyQueue {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        /** Initialize your data structure here. */
        public MyQueue() {
            stackIn = new Stack<>(); // 负责进栈
            stackOut = new Stack<>(); // 负责出栈
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            if(!stackOut.isEmpty()){
                return stackOut.pop();
            }
            while(!stackIn.isEmpty()){
                Integer temp = stackIn.pop();
                stackOut.push(temp);
            }
            return stackOut.pop();
        }

        public int peek() {
            int res=0;
            if(!stackOut.isEmpty()){
                return stackOut.peek();
            }
            while(!stackIn.isEmpty()){
                Integer temp = stackIn.pop();
                stackOut.push(temp);
            }
            return stackOut.peek();
        }

        public boolean empty() {
            return stackOut.isEmpty()&&stackIn.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
