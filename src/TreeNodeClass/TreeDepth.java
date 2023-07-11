package TreeNodeClass;

/**
 * 题目：输入一棵二叉树，求该树的深度。
 *      从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 思路：递归获取左右子树 的 深度， 采用的是后序遍历 (左右中)
 *
 */
public class TreeDepth {
    public static void main(String[] args) {
        TreeNode rootleft=new TreeNode(2);
        rootleft.setLeft(new TreeNode(4));
        TreeNode fivetoseven=new TreeNode(5);
        fivetoseven.setLeft(new TreeNode(7));
        rootleft.setRight(fivetoseven);
        TreeNode rootright=new TreeNode(3);
        rootright.setRight(new TreeNode(6));
        TreeNode root=new TreeNode(1);
        root.setRight(rootright);
        root.setLeft(rootleft);
        TreeDepth treeDepth=new TreeDepth();
        System.out.println(treeDepth.TreeDepth(root));
    }
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=TreeDepth(root.left);
        int right= TreeDepth(root.right);
        return 1+Math.max(left,right);
    }
}
