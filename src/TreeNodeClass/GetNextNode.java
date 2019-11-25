package TreeNodeClass;

/**
 * 题目：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *
 * 思路：有右子节点
 *              右子节点有无左子节点
 *              无 —— 右子节点就是当前结点下一节
 *              有 —— 递归寻找右子节点的左子节点就是下一节点
 *      无右子节点
 *              无父节点 —— 无下一结点
 *              有父节点
 *                  当前结点作为父节点的左子节点 —— 下一结点为父节点
 *                  当前结点作为父节点的右子节点 —— 向父节点递归寻找作为左子节点的结点就是下一节点
 *
 * 注意：树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 *
 */

public class GetNextNode {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    /*public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null){
            return null;
        }
        TreeLinkNode pnext=null;
        if(pNode.right!=null){  //如果有右子树，则找右子树的最左节点
            TreeLinkNode pRight=pNode.right;
            while(pRight.left!=null){
                pRight=pRight.left;
            }
            pnext=pRight;
        }else if(pNode.next!=null){     //没右子树，则找第一个当前节点是父节点左孩子的节点
            TreeLinkNode curnode=pNode;
            TreeLinkNode parentnode=pNode.next;
            while(parentnode!=null&&curnode==parentnode.right){
                curnode=parentnode;
                parentnode=parentnode.next;
            }
            pnext=parentnode;
        }
        return pnext;
    }*/
    TreeLinkNode GetNext(TreeLinkNode node)
    {
        if(node==null) return null;
        if(node.right!=null){    //如果有右子树，则找右子树的最左节点
            node = node.right;
            while(node.left!=null) node = node.left;
            return node;
        }
        while(node.next!=null){ //没右子树，则找第一个当前节点是父节点左孩子的节点
            if(node.next.left==node) return node.next;
            node = node.next;
        }
        return null;   //退到了根节点仍没找到，则返回null
    }
}
