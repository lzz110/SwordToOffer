package TreeNodeClass;

/**
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *      要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：中序遍历
 */
public class BinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode rootleft=new TreeNode(6);
        rootleft.setLeft(new TreeNode(4));
        rootleft.setRight(new TreeNode(8));
        TreeNode rootright=new TreeNode(14);
        rootright.setLeft(new TreeNode(12));
        rootright.setRight(new TreeNode(16));
        TreeNode root=new TreeNode(10);
        root.setRight(rootright);
        root.setLeft(rootleft);

        TreeNode treeNode = new BinaryTreeToLinkedList().Convert(root);
        while(treeNode!=null){
            System.out.println(treeNode.val);
            treeNode=treeNode.right;
        }


    }

    TreeNode tail = null;       //tail是排序后的最后一个结点
    TreeNode realHead = null;   //realHead是每个子树排序后的第一个结点
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;   //递归退出条件
        ConvertSub(pRootOfTree.left);
        if (tail == null) {             //第一次找到最小的节点
            tail = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            tail.right = pRootOfTree;   //链表的next指针   新节点与之前节点左右连接
            pRootOfTree.left = tail;    //链表的pre指针
            tail = pRootOfTree;         //链表 往下走一步
        }
        ConvertSub(pRootOfTree.right);
    }
}
