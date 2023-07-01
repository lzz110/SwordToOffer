package ListNodeClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/23 16:53
 *
 * 题目： 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 示例 1：输入：head = [1,2,6,3,4,5,6], val = 6  输出：[1,2,3,4,5]
 *
 *  思路：
 *      设置虚拟头结点 dummy , 并将dummy 的下一节点指向 head 即： dummy.next == head;
 *
 *
 */
public class RemoveElement {

    public ListNode removeElements(ListNode head, int val) {
        //创建一个虚拟头结点
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        //确保当前结点后还有结点
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }

/**
 *
 *19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：  输入：head = [1,2,3,4,5], n = 2   输出：[1,2,3,5]
 * 示例 2：  输入：head = [1], n = 1  输出：[]
 * 示例 3：  输入：head = [1,2], n = 1  输出：[1]
 *
 * 思路：
 *      快慢指针，先让快指针先走n 步， 之后两个指针一起走，当 fast。next ==null , slow 指针指向的就是 倒数第n 个节点的前一个节点
 *      为了保证 slow.next.next != null , 建议 slow 和 fast 从虚拟节点 出发， 如果从head 出发，当head = [1] n = 1 时，slow.next.next == null
 *      ListNode fast = dummy;   ListNode slow = dummy;
 */
public ListNode removeNthFromEnd(ListNode head, int n) {
    //快慢指针
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    for(int i=0;i<n;i++){
        fast = fast.next;
    }

    while(fast.next !=null){
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;

    return dummy.next;
}


}
