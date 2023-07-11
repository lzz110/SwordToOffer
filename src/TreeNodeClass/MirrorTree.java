package TreeNodeClass;

/**
 * 题目：输出该二叉树的镜像树（直接在原来的树上修改）
 *
 * 思路：递归交换 左右子树，采用 后序遍历（左右中）和 前序遍历（中左右） 都行
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return root;
        mirrorTree(root.left);
        mirrorTree(root.right);
        swap(root);
        return root;
    }
    public void swap(TreeNode node){
        TreeNode temp= node.left;
        node.left= node.right;
        node.right=temp;
    }


}
