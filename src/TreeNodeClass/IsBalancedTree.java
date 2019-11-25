package TreeNodeClass;

/**
 * 题目：输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 思路：
 *      方法一：从下向上求 可以减少重复计算
 *      方法二：从上向下求 先求深度 再判断是否平衡
 *
 */
public class IsBalancedTree {

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
        IsBalancedTree isBalancedTree=new IsBalancedTree();
        System.out.println(isBalancedTree.IsBalanced_Solution(root));
    }

    //常规解法  从上往下 会造成子树重复计算
    /*
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
            return true;
        return Math.abs(GetTreeDepth(root.left)-GetTreeDepth(root.right))<=1    //计算一遍root节点的左右节点深度
                && IsBalanced_Solution(root.left)           //又计算一遍root.left节点的左右节点深度
                && IsBalanced_Solution(root.right);         //又计算一遍root.right节点的左右节点深度
    }

    private int GetTreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        int leftdepth=GetTreeDepth(root.left);
        int rightdepth=GetTreeDepth(root.right);
        return leftdepth>rightdepth?leftdepth+1:rightdepth+1;
    }
    */

    //剑指思想  从下往上
    public boolean IsBalanced_Solution(TreeNode root) {
        return getdepth(root)!=-1;
    }

    private int getdepth(TreeNode root) {
        if(root==null)
            return 0;
        int left=getdepth(root.left);
        if(left==-1)
            return -1;
        int right=getdepth(root.right);
        if(right==-1)
            return -1;
        return Math.abs(left-right)>1?-1:1+Math.max(left,right);
    }
}
