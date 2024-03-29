package StackAndQueneClass;

import java.util.*;

/**
 *
 *
 * 使用数组来实现一个栈，并且这个栈具有push()、pop()（返回栈顶元素并出栈）、peek() （返回栈顶元素不出栈）、isEmpty()、size()这些基本的方法。
 *
 *
 * 提示：每次入栈之前先判断栈的容量是否够用，如果不够用就用Arrays.copyOf()进行扩容；
 *
 */
public class ArrayImplementStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack(3);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        System.out.println(myStack.peek());//8
        System.out.println(myStack.size());//8
        for (int i = 0; i < 8; i++) {
            System.out.println(myStack.pop());
        }
        System.out.println(myStack.isEmpty());//true
        myStack.pop(); //报错：java.lang.IllegalArgumentException: Stack is empty.

    }

    public static class MyStack {
        private int[] storage;//存放栈中元素的数组
        private int capacity;//栈的容量
        private int count;//栈中元素数量
        private static final int GROW_FACTOR = 2;

        //不带初始容量的构造方法。默认容量为8
        public MyStack() {
            this.capacity = 8;
            this.storage=new int[8];
            this.count = 0;
        }

        //带初始容量的构造方法
        public MyStack(int initialCapacity) {
            if (initialCapacity < 1)
                throw new IllegalArgumentException("Capacity too small.");

            this.capacity = initialCapacity;
            this.storage = new int[initialCapacity];
            this.count = 0;
        }

        //入栈
        public void push(int value) {
            if (count == capacity) {
                ensureCapacity();
            }
            storage[count++] = value;
        }

        //确保容量大小
        private void ensureCapacity() {
            int newCapacity = capacity * GROW_FACTOR;
            storage = Arrays.copyOf(storage, newCapacity);
            capacity = newCapacity;
        }

        //返回栈顶元素并出栈
        private int pop() {
            if (count == 0)
                throw new IllegalArgumentException("Stack is empty.");
            count--;
            return storage[count];
        }

        //返回栈顶元素不出栈
        private int peek() {
            if (count == 0){
                throw new IllegalArgumentException("Stack is empty.");
            }else {
                return storage[count-1];
            }
        }

        //判断栈是否为空
        private boolean isEmpty() {
            return count == 0;
        }

        //返回栈中元素的个数
        private int size() {
            return count;
        }

    }

}
