package StackAndQueneClass;

import java.util.Stack;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 思路：定义两个栈 一个栈存值 另一个栈存当前栈的最小指
 * 注意: pop() 操作 中 要保证两个栈是高度对齐的 两个栈都要pop
 */
public class minstack {

    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {
        if(data.isEmpty()){
            data.push(node);
            min.push(node);
        }else{
            Integer temp=min.peek();
            if(temp<node){
                min.push(temp);
            }else{
                min.push(node);
            }
            data.push(node);
        }
    }

    public void pop() {
        min.pop();  //保证两个栈对齐
        data.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
