package ListNodeClass;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：
 *      输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * 思路：
 *      方法一： 利用栈
 *      方法二： 递归打印:如果该节点不为null 则 递归打印该节点的下一个节点
 */
public class PrintlListfFromTailToHead {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        ListNode hero1 = new ListNode(1);
        ListNode hero2 = new ListNode(2);
        ListNode hero3 = new ListNode(3);
        ListNode hero4 = new ListNode(4);


        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);


        ArrayList<Integer> res = new PrintlListfFromTailToHead().printListFromTailToHead(hero1);
        for (Integer re : res) {
            System.out.print(re+"--");
        }
    }

    //使用栈

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res=new ArrayList<>();
        if(listNode==null)
            return res;
        Stack<Integer> stack=new Stack<>();
        while(listNode!=null){
            stack.push( listNode.val);
            listNode=listNode.next;
        }
        while(!stack.isEmpty()){
            Integer integer = stack.pop();
            res.add(integer);
        }
        return res;
    }


    /*

    //递归调用
    public class Solution {
        ArrayList<Integer> res=new ArrayList<>();
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            if(listNode!=null){		//注意是if 不是while
                printListFromTailToHead(listNode.next);
                res.add(listNode.val);
            }
            return res;
        }
    }
    */

}