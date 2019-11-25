package ListNodeClass;

/**
 * 公用链表方法
 *
 * 1.向链表尾部 添加节点
 * 2.正序打印链表
 *
 */
public class SingleLinkedList {

    private ListNode head=new ListNode(0);

    public ListNode getHead() {
        return head;
    }
    public void setHead(ListNode head) {
        this.head = head;
    }

    public void add(ListNode listNode){
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=listNode;
    }


    public void print(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+"--->");
            temp=temp.next;
        }
    }
}
