package ListNodeClass;

/**
 *  题目：反转链表
 *
 *  思路： 定义 三个节点 当前节点  前一节点  后一节点
 *    	   依次更新 当前节点的next指针 前一节点 当前节点
 *
 */
public class ReverseLinkedList {



    public ListNode ReverseList(ListNode head){
        ListNode pre=null;          //指向前一节点
        ListNode pnode=head;        //指向当前节点
        ListNode reverseHead=null;
        while(pnode!=null){
            ListNode pnext=pnode.next;
            if(pnext==null)         //走到链表尾部了,把当前节点给到反转头
                reverseHead=pnode;
            pnode.next=pre;         //反转当前节点的next指针
            pre=pnode;              //更新上一个节点
            pnode=pnext;            //更新当前节点
        }
        return reverseHead;
    }
}
