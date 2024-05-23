package ListNodeClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/23 18:54
 * 
 * 注意： 链表中 删除结点需要分为 删除头结点和 删除非头节点； 
 *      因为删除非头节点 需要找到前一个节点，并调整其 next 指针
 *      删除头节点时，直接调整 head 指针即可
 * 
 *      链表中找当前节点的前一个节点：
 *      while(index>0){
 *           cur=cur.next;
 *           index--;
 *      }
 *      链表中找当前节点：
 *      while(index>=0){
 *           cur=cur.next;
 *           index--;
 *      }
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
        ListNode newnode= new ListNode(val);  // 创建新的节点
       newnode.next = pre.next;   // 新节点的 next 指向前一个节点的 next
       pre.next = newnode;  // 前一个节点的 next 指向新节点
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
