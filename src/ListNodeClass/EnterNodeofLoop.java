package ListNodeClass;

/**
 * 题目：
 *      给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 思路：
 *      先 双指针 判断链表是否有环 ，没有直接return null
 *      有环的话 得到指针相遇的节点 （一定在环中） 计算环中节点的个数 n
 *      再次使用 双指针 让前面的指针先走 n 步 之后 两个指针一起走 再次遇到的节点就是 入口节点
 *
 */


public class EnterNodeofLoop {

    public static void main(String[]args){
        ListNode pHead=new ListNode(1);
        ListNode two=new ListNode(2);
        ListNode three=new ListNode(3);
        ListNode four=new ListNode(4);
        four.next=two;
        pHead.addNode(two);
        pHead.addNode(three);
        pHead.addNode(four);

    }
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead==null)
            return null;
        ListNode TrashNode=null;

        //先判断有没有环
        if(ListHasCircle(pHead)==null)
            return null;
        else{
            TrashNode=ListHasCircle(pHead);
        }

        //计算环中节点数
        int count=1;
        ListNode temp= TrashNode;
        while(temp.next.val!=TrashNode.val){
            temp=temp.next;
            count++;
        }

        ListNode first=pHead;
        temp=pHead;
        while(count!=0){
            first=first.next;
            count--;
        }
        while(temp.val!=first.val){
            temp=temp.next;
            first=first.next;
        }

        return temp;
    }

    private ListNode ListHasCircle(ListNode pHead) {

        ListNode fast=pHead;
        ListNode low=pHead;
        while(low.next!=null&&fast.next.next!=null){
            low=low.next;
            fast=fast.next.next;
            if(low.val==fast.val)
                return low;
        }
        return null;
    }

























   /*
   public ListNode EntryNodeOfLoop(ListNode pHead){
        ListNode meetnode=null;
        ListNode entrynode=null;
        if(hascircle(pHead)!=null)
            meetnode=hascircle(pHead);
        else
            return null;
        ListNode ptemp=meetnode;
        //get circle has number nodes
        int number=1;
        while(ptemp.next!=meetnode){
            ptemp=ptemp.next;
            number++;
        }
        //让plast 走 number 个节点
        ListNode pfront=pHead;
        ListNode plast=pHead;
        for(int i=0;i<number;i++){
            plast=plast.next;
        }
        //当pfront== plast 就是入口节点
        while(pfront!=plast){
            pfront=pfront.next;
            plast=plast.next;
        }
        entrynode=plast;
        return entrynode;
    }
    public ListNode hascircle(ListNode pHead){
        ListNode pfront=pHead;
        ListNode plast=pHead;
        while(plast.next!=null&&pfront.next.next!=null){
            plast=plast.next;
            pfront=pfront.next.next;
            if(pfront==plast){
                return plast;
            }
        }
        return null;
    }
    */
}
