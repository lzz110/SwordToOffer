package ListNodeClass;

import ListNodeClass.ListNode;
import java.util.List;

/**
 * 题目：输入一个链表，输出该链表中倒数第k个结点。
 * 思路：
 *      方法一：先遍历一遍得到链表长度 再走到 n-k+1个节点
 *      方法二：第一个指针比第二个指针先走k-1 当第一个指针走到链表尾部 第二个指向第n-k+1个节点
 */

public class FingKthTotail {
    public static void main(String[] args) {
        ListNode head=new ListNode(0);
        ListNode one=new ListNode(1);
        ListNode two=new ListNode(2);
        ListNode three=new ListNode(3);

        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(head);
        singleLinkedList.add(one);
        singleLinkedList.add(two);
        singleLinkedList.add(three);

        //singleLinkedList.print(head);
        ListNode res=new FingKthTotail().FindKthToTail(head,2);

        System.out.println(res.val);
    }

    //先遍历一遍得到链表长度 再走到 n-k+1个节点
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null)
            return null;
        int len=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        if(k>len)
            return null;
        temp=head;
        for(int i=1;i<len-k+1;i++){
            temp=temp.next;
        }
        return temp;
    }

    //第一个指针比第二个指针先走k-1 当第一个指针走到链表尾部 第二个指向第n-k+1个节点
    /*public  ListNode FindKthToTail(ListNode head,int k){
        if(head==null)
            return null;
        if(k==0)
            return null;
        ListNode first=head;
        ListNode last=head;
        for(int i=0;i<k-1;i++){
            if(first.next!=null){
                first=first.next;
            }else{
                return null;
            }
        }
        while(first.next!=null){
            first=first.next;
            last=last.next;
        }
        return last;
    }*/

}
