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

    /**
     * 19. 删除链表的倒数第 N 个结点
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

     * 示例 1：输入：head = [1,2,3,4,5], n = 2  输出：[1,2,3,5]
     *
     *
     * 思路： 关键需要找到倒数第 N 个 节点的前一个节点，
     * 使用快慢指针，让快指针先走 n 步， 之后快慢指针一起走，当快指针的 next == null , 慢指针指向的就是 倒数第 N 个节点
     *
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        while(fast.next !=null){
            slow=slow.next ;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

    }

}
