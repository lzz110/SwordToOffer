package ListNodeClass;

/**
 *  Leetcode 2 两数相加
 *
 *  注意 定义一个Head 节点 为 -1 , 并定义一个res 指向 Head, 最后返回Head.next
 *
 *
 */
public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode Head= null;
        ListNode Head= new ListNode(-1);
        ListNode res=Head;
        ListNode p1=l1,p2=l2;
        int carry=0,newValue=0;
        while(p1!=null||p2!=null||carry>0){
            newValue = (p1==null?0:p1.val) + (p2==null?0:p2.val)+carry;
            carry=newValue/10;
//            ListNode temp=new ListNode(newValue%10);
//            res.next = temp;
            res.next = new ListNode(newValue%10);
            //链表更新
            p1= p1==null?null:p1.next;
            p2= p2==null?null:p2.next;
            res=res.next;
        }
//        return res.next;
        return Head.next;
    }
}
