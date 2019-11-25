package StackAndQueneClass;


import java.util.Stack;

/**
 * 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 思路：弹出操作时，先判断栈2有没有元素，有的话直接弹出
 *      没有从 栈1 中拿出元素 放在栈2，并弹出
 *      要考虑栈为空的情况
 */
public class TwoStackImplemtQueen {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public static void main(String[] args) {
        TwoStackImplemtQueen twoStackImplemtQueen = new TwoStackImplemtQueen();
        twoStackImplemtQueen.push(1);
        twoStackImplemtQueen.push(2);
        System.out.println(twoStackImplemtQueen.pop());
        twoStackImplemtQueen.push(4);
        System.out.println(twoStackImplemtQueen.pop());
        twoStackImplemtQueen.push(6);
        twoStackImplemtQueen.push(8);
        System.out.println(twoStackImplemtQueen.pop());
        System.out.println(twoStackImplemtQueen.pop());
        System.out.println(twoStackImplemtQueen.pop());

    }
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty()&&stack2.isEmpty())
            throw new RuntimeException("Queue is empty!");
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        while(!stack1.isEmpty()){
            Integer temp = stack1.pop();
            stack2.push(temp);
        }
        return stack2.pop();
    }
}
