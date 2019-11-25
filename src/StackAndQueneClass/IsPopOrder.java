package StackAndQueneClass;

import java.util.Stack;

/**
 *  题目：
 *      输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *      例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 *      但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *  思路：
 *      创建一个辅助栈 直到辅助栈的栈顶==栈的弹出顺序 弹出后判断下一个是否相等 不等的话继续入栈
 *      最后返回 辅助栈 是否为空
 */
public class IsPopOrder {
    public static void main(String[] args) {
//        int[] pushA={1,2,3,4,5};
//        int[] popA={4,5,3,2,1};
        int[] pushA={};
        int[] popA={};
        System.out.println(new IsPopOrder().IsPopOrder(pushA,popA));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack=new Stack<>();
        int popindex=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.empty()&&stack.peek()==popA[popindex]){
                stack.pop();
                popindex++;
            }
        }
        return stack.isEmpty();
    }

}
