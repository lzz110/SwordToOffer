package ListNodeClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/23 18:54
 */
public class MyLinkedList {

    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        //特判
        if(index <0 || index >= size){
            return -1;
        }

        ListNode cur = head;
        while(index>=0){
            cur=cur.next;
            index--;
        }
        return cur.val;
    }

    public void addAtHead(int val) {

        addAtIndex(0,val);
    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        //特判
        if( index <0 || index > size){
            return ;
        }
        size++;
        //找到需要添加节点的前一个节点
        ListNode pre= head;
        while(index>0){
            pre=pre.next;
            index--;
        }
        ListNode newnode= new ListNode(val);
        newnode.next = pre.next;
        pre.next = newnode;
    }

    public void deleteAtIndex(int index) {
        //特判
        if(index <0 || index >= size){
            return ;
        }
        size--;
        //如果index = 0
        if (index == 0) {
            head = head.next;
            return;
        }
        //找到需要删除节点的前一个节点
        ListNode pre= head;
        while(index>0){
            pre=pre.next;
            index--;
        }
        pre.next = pre.next.next;
    }
}
