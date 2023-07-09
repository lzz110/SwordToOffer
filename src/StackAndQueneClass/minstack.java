package StackAndQueneClass;

import java.util.Stack;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 思路：定义两个栈 一个栈存值 另一个栈存当前栈的最小指
 *
 * 数据栈A ：
 *      栈A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
 * 辅助栈B ：
 *      栈B 中存储栈 A 中所有 非严格降序 的元素，则栈 A 中的最小元素始终对应栈 B 的栈顶元素，即 min() 函数只需返回栈 B 的栈顶元素即可。
 *
 * 注意: pop() 操作 或者 peek() 操作之前 要保证栈不空
 */
public class minstack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /** initialize your data structure here. */
    public minstack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()||stack2.peek()>=x){
            stack2.push(x);
        }
    }

    public void pop() {
        if(stack1.peek().equals(stack2.peek())){
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        if(!stack1.isEmpty())
        return stack1.peek();
        return 0;
    }

    public int min() {
        if(!stack2.isEmpty())
            return stack2.peek();
        return 0;
    }


//
}
