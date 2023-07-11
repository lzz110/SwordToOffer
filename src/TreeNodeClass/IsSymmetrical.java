package TreeNodeClass;

import TreeNodeClass.TreeNode;

/**
 * 题目：
 *       判断一颗二叉树是不是对称的 如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 * 思路：
 *       方法一：
 *              遍历方法只能是“后序遍历”，因为我们要通过递归函数的返回值来判断两个子树的内侧节点和外侧节点是否相等。
 *              正是因为要遍历两棵树而且要比较内侧和外侧节点，所以准确的来说是一个树的遍历顺序是左右中，一个树的遍历顺序是右左中。
 *
 *       方法二：
 *              将所给的树复制一份 两个树一起判断
 *              先递归判断 根节点 A.val == B.val
 *              再递归判断 A.left == B.right && A.right == B.left
 */
public class IsSymmetrical {

    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left, root.right);
    }
    public boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right!=null) return false;
        if(left!=null&&right==null) return false;
        if(left==null&&right==null) return true;
        if(left.val!=right.val) return false;

        boolean outside = compare(left.left,right.right);
        boolean inside = compare(left.right,right.left);
        return outside&&inside;
    }



    /*
    boolean isSymmetrical(TreeNode pRoot) {
        return issymmetrical(pRoot,pRoot);
    }
    boolean issymmetrical(TreeNode proot1,TreeNode proot2){
        if(proot1==null&&proot2==null)
            return true;
        if(proot1==null||proot2==null)
            return false;
        if(proot1.val!=proot2.val)
            return false;
        return issymmetrical(proot1.left,proot2.right)&&issymmetrical(proot1.right,proot2.left);
    }*/

}
