package ListNodeClass;

/**
 * 题目：输入两个链表，找出它们的第一个公共结点。
 *
 * 思路：先让长的链表先走 diff（long-short） 步
 *      之后一起走 值相同的就是公共节点
 */
public class FirstFirstComonNode {
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
