package ListNodeClass;

/**
 * 题目：输入两个链表，找出它们的第一个公共结点。
 *			1->2->3
 *					->4->5
 *			1->3
 * 思路：
 *      方法一：
 *          构建两个节点指针 A , B 分别指向两链表头节点 headA , headB
 *          如果指针A 遍历完就爱是遍历指针 B， 指针B 同理，
 *          若两链表 有 公共尾部 (即 c>0 ) ：指针 A , B 同时指向「第一个公共节点」node 。
 *          若两链表 无 公共尾部 (即 c=0 ) ：指针 A , B 同时指向 null
 *          最后返回 A 即可
 *
 *      方法二：
 *          先让长的链表先走 diff（long-short） 步
 *          之后一起走 值相同的就是公共节点
 */
public class FirstFirstComonNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A= headA;
        ListNode B = headB;
        while(A!=B){

            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    public  ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int  phead1length=getlength(pHead1);
        int  phead2length=getlength(pHead2);
        ListNode plong=phead1length>phead2length?pHead1:pHead2;
        ListNode pshort=phead1length<phead2length?pHead1:pHead2;
        int diff=Math.abs(phead1length-phead2length);

        //先走diff步
        for(int i=0;i<diff;i++){
            plong=plong.next;
        }

        //一起走找第一个相同的
        while(plong!=null&&pshort!=null&&plong.val!=pshort.val){
            plong=plong.next;
            pshort=pshort.next;
        }
        ListNode res=pshort;
        return res;
    }
    public int getlength(ListNode pHead){
        int length=0;
        ListNode temp=pHead;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

}
