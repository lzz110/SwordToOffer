package ListNodeClass;

/**
 * 公用单向链表节点类
 * 节点属性 ： val  next
 *
 */
public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    //向末尾添加节点方法
    public void addNode(ListNode newNode){
        if(this.next==null){
            this.next = newNode;
        }else{
            this.next.addNode(newNode);
        }
    }

    //打印节点方法
    public void printNode(){
        System.out.print(this.val + "-->");
        if(this.next!=null){
            this.next.printNode();
        }
    }
}
