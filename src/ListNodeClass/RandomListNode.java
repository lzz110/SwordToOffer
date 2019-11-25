package ListNodeClass;

/**
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *      返回结果为复制后复杂链表的head。
 * 思路：
 *      1. 把复制的结点链接在原始链表的每一对应结点后面
 *      2. 把复制的结点的random指针指向被复制结点的random指针的下一个结点
 *      3. 拆分成两个链表，奇数位置为原链表，偶数位置为复制链表，
 *         注意复制链表的最后一个结点的next指针不能跟原链表指向同一个空结点None
 *         next指针要重新赋值None(判定程序会认定你没有完成复制）
 */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }



    public RandomListNode Clone(RandomListNode pHead)
    {
        //复制节点
        CloneNode(pHead);
        //连接任意节点
        ConnectRandomNode(pHead);
        //拆分链表
        return ReconnectListNode(pHead);
    }

    private RandomListNode ReconnectListNode(RandomListNode pHead) {
        RandomListNode ptemp=pHead;
        RandomListNode prealhead=null;
        RandomListNode prealtemp=null;

        if(ptemp!=null){
            prealhead=prealtemp=ptemp.next;
            ptemp.next=prealtemp.next;
            ptemp=ptemp.next;
        }
        while(ptemp!=null){
            prealtemp.next=ptemp.next;
            prealtemp=prealtemp.next;

            ptemp.next=prealtemp.next;
            ptemp=ptemp.next;
        }
        return prealhead;
    }

    private void ConnectRandomNode(RandomListNode pHead) {
        RandomListNode ptemp=pHead;
        while(ptemp!=null){
            RandomListNode pclone=ptemp.next;
            //求一个节点的next之前要先判断 该节点 是否为null
            if(ptemp.random!=null)
                pclone.random=ptemp.random.next;

            ptemp=pclone.next;
        }
    }

    private void CloneNode(RandomListNode pHead) {
        RandomListNode ptemp=pHead;
        while(ptemp!=null){
            RandomListNode pclone=new RandomListNode(ptemp.label);
            pclone.next=ptemp.next;
            pclone.random=null;     //next指针要重新赋值None(判定程序会认定你没有完成复制）
            ptemp.next=pclone;
            ptemp=pclone.next;
        }
    }

}

