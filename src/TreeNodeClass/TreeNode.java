package TreeNodeClass;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+"  ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

}
