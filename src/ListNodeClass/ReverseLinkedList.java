package ListNodeClass;

/**
 *  题目：反转链表
 *
 *  思路： 定义 三个节点 当前节点  前一节点  ，后一节点，其中后一节点是在循环中定义的
 *
 *    	  依次更新 当前节点的next指针， 前一节点 ，当前节点
 *
 *          返回的时候返回 pre , 因为退出循环时，pre 指向的是 cur
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;    //指向当前节点
        ListNode pre = null;    //指向前一节点
        while( cur != null){
            ListNode temp = cur.next;  //保存下一节点的值
            cur.next = pre;         //反转当前节点的next指针
            pre = cur;               //更新上一个节点
            cur = temp;             //更新当前节点
        }
        return pre;
    }

    /**
     * leetcode 24. 两两交换链表中的节点
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     *
     * 示例 1  输入：head = [1,2,3,4]   输出：[2,1,4,3]
     *
     * 思路： https://www.bilibili.com/video/BV1YT411g7br/?spm_id_from=333.788&vd_source=863a059723c7940f38655c3384b44639
     *
     *
     * @param head
     * @return
     */

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);  // 设置一个虚拟头结点
        dummy.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null) {

            ListNode start = cur.next;      // 临时节点，保存两个节点之中的第一个节点
            ListNode middle = cur.next.next;   // 临时节点，保存两个节点之中的第二个节点
            ListNode end = cur.next.next.next;  // 临时节点，保存两个节点后面的节点
            cur.next = middle;
            middle.next = start;
            start.next = end;
            cur = start;                    // cur移动，准备下一轮交换
        }
        return dummy.next;
    }
}
