package ListNodeClass;

/**
 *  题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 *  思路：
 *        递归:    ListNode mergeList=null;    //只要不new  地址不变 一直是这个
 *        非递归
 *                 非递归   人造节点head，完美避开了头结点为空的情况
 *                 要多定义一个root节点 的原因 程序运行之后 head节点不是指向头结点
 *                 退出 while 循环之后 直接将剩下的链表添加到 root节点之后
 */
public class MergeTwoList {
    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        ListNode listNode1=new ListNode(2);
        ListNode listNode2=new ListNode(3);
        ListNode listNode3=new ListNode(4);

        SingleLinkedList list1=new SingleLinkedList();
        list1.add(listNode);
        list1.add(listNode2);

        SingleLinkedList list2=new SingleLinkedList();
        list2.add(listNode1);
        list2.add(listNode3);

        list1.print(listNode);
        System.out.println();
        list1.print(listNode1);
        System.out.println();
        ListNode res=new MergeTwoList().Merge(listNode,listNode1);
//        ListNode res=new MergeTwoList().Merge(null,null);

        list1.print(res);
    }




    //递归
    /*public  ListNode Merge(ListNode list1, ListNode list2){
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode mergeList=null;    //只要不new  地址不变 一直是这个
        if(list1.val<list2.val){
            mergeList=list1;
            mergeList.next= Merge(list1.next,list2);
        }else{
            mergeList=list2;
            mergeList.next= Merge(list1,list2.next);
        }
        return mergeList;
    }*/


    //非递归   并且人造节点head，完美避开了头结点为空的情况
    //要多一个root节点 的原因 程序运行之后 head节点不是指向头结点
    //退出while 循环之后 直接将剩下的链表添加到 root节点之后
    public ListNode Merge(ListNode list1,ListNode list2) {
       ListNode head=new ListNode(-1);
       head.next=null;		//将当前节点的next 指向空
       ListNode root=head;
       while(list1!=null&&list2!=null){
           if(list1.val<list2.val){
               head.next=list1;
               head=list1;
               list1=list1.next;
           }else{
               head.next=list2;
               head=list2;
               list2=list2.next;
           }
       }
       if(list1==null)
           head.next=list2;
       if(list2==null)
           head.next=list1;
       return root.next;
    }

}
