package ListNodeClass;

/**
 * 题目：输入两个链表，找出它们的第一个公共结点。
 *			1->2->3
 *					->4->5
 *			1->3
 *
 *
 * 思路：
 *      方法一：
 *          两个指针长度不同无所谓，只要全部遍历两个指针，总的路径是一样的，因此如果没有公共结点，两者的最后一个公共结点就是null
 *          所以遍历的条件可以写成  while(A!=B) , A , B 分别指向两链表头节点 headA , headB
 *
 *          构建两个节点指针 A , B 分别指向两链表头节点 headA , headB
 *          如果指针A 遍历完就爱是遍历指针 B， 指针B 同理，
 *          若两链表 有 公共尾部 (即 c>0 ) ：指针 A , B 同时指向「第一个公共节点」node 。
 *          若两链表 无 公共尾部 (即 c=0 ) ：指针 A , B 同时指向 null
 *          最后返回 A 即可
 *      方法二：
 *          先让长的链表先走 diff（long-short） 步
 *          之后一起走 值相同的就是公共节点
 */
public class FirstCommonNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A= headA;
        ListNode B = headB;
        while(A!=B){

            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    /**
     * 
     * 好理解的方法一：
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
    
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
    
        while (tmp1 != null && tmp2 != null) {
            if (tmp1 == tmp2) {
                return tmp1;
            }
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
            // 如果 tmp1 或 tmp2 到达链表末尾，则将其重置为另一个链表的头
            if (tmp1 == null && tmp2 != null) {
                tmp1 = headB;
            }
            if (tmp2 == null && tmp1 != null) {
                tmp2 = headA;
            }
        }
    
        return null;
    }
    public  ListNode FirstCommonNode(ListNode pHead1, ListNode pHead2) {
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
