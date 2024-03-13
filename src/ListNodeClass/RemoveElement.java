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
 *  技巧： 设置虚拟头结点 dummy , 并将dummy 的下一节点指向 head 即： dummy.next == head;
 *
 *  思路一：设置一个当前节点 cur 指向 dummy ,
 *          循环条件是当前结点后结点值不为null
 *          如果 cur.next.val==val 则 修改cur.next 的指向，否则将cur 后移
 *
 *  思路二：设置一个前一个节点 pre 指向 dummy , 一个  当前节点 cur 指向 head
 *           循环条件是当前结点值不为null
 *              如果 cur.val==val 则 修改 pre.next 的指向，否则将 pre 指向 cur
 *              最后将cur 后移
 */
public class RemoveElement {

    /**
     * 思路一
     * @param head
     * @param val
     * @return
     */
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
     * 思路二
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre =dummy;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;

            }else{
                pre=cur;
            }
            cur=cur.next;

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

    /**
     *
     * 剑指 Offer 22. 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     * 思路一： 快慢指针，见上面的解答
     * 思路二： 先获取链表长度，再让链表走len -k 个长度，之后return head .next 即可，注意 len=k 的情况
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        int len=0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        if(len==k){
            return head;
        }
        for(int i=1;i<len-k;i++){
            head=head.next;
        }
        return head.next;
    }

}
