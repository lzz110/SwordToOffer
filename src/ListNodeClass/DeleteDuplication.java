package ListNodeClass;

/**
 * 题目：
 *      在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 *      例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 思路：
 *      定义当前指针 p 和前一个指针 last  当 p.val==p.next.val  p 向后移动 直到前面没有相等的val
 *      把val 拿出来 跟p 循环比较 相等的话 p=p.next 不等的话 last.next=p
 * 技巧：
 *      定义一个节点为0 让它的 next 指向 链表的头 返回的时候 返回该节点的 next
 *      如：ListNode n=new ListNode(0);  n.next=pHead; return n.next;
 *
 */


public class DeleteDuplication {
    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null)
            return null;
        ListNode n=new ListNode(0);
        n.next=pHead;
        ListNode p=pHead;
        ListNode last=n;
        while(p!=null&&p.next!=null){
            if(p.val==p.next.val){
                int val=p.val;
                while(p!=null&&p.val==val){
                    p=p.next;
                }
                last.next=p;
            }else{
                last=p;
                p=p.next;
            }
        }
        return n.next;
    }









    /*
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null)
            return null;
        ListNode p=pHead;
        ListNode n=new ListNode(0);
        n.next=pHead;
        ListNode last=n;

        while(p!=null&&p.next!=null){
            if(p.val==p.next.val){
                int val=p.val;
                while(p!=null&&p.val==val){
                    p=p.next;
                }
                last.next=p;
            }else{
                last=p;
                p=p.next;
            }
        }
        return n.next;
    }
    */
}
