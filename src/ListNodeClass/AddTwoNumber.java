package ListNodeClass;

/**
 *  Leetcode 2 两数相加
 *
 *  注意 定义一个Head 节点 为 -1 , 并定义一个res 指向 Head, 最后返回Head.next
 *  括号运算符 >  加法运算法  > 三元运算符
 *      // int newValue = (p1==null?0:p1.val) + (p2==null?0:p2.val)+carry;
 *      // 上面的代码 会分别评估p1和p2是否为null，并分别加上它们的val值（如果不是null的话）或0，再加上cur。
 *
 *      // int newValue = p1==null?0:p1.val + (p2==null?0:p2.val) + cur;
 *      // 上面的代码  p1.val会先与(p2==null?0:p2.val)的结果相加，再与cur相加。
 *      // 但是，这个加法运算只有在p1不是null的情况下才会执行。如果p1是null，那么整个表达式的结果将只是0，忽略了p2和cur的值。
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
