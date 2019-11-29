package TreeNodeClass;

/**
 * 题目：输出该二叉树的镜像树（直接在原来的树上修改）
 *
 * 思路：递归交换 左右子树
 */
public class MirrorTree {

    public void Mirror(TreeNode root) {
        if(root==null)
            return ;
        if(root.left==null&&root.right==null)   // 不加判断也行 加这个判断会更快一点
            return ;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.left!=null)
            Mirror(root.left);
        if(root.right!=null)
            Mirror(root.right);
    }
}
