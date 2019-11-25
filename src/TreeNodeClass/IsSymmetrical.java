package TreeNodeClass;

import TreeNodeClass.TreeNode;

/**
 * 题目：
 *       判断一颗二叉树是不是对称的
 * 思路：
 *       先递归判断 根节点 A.val == B.val
 *       再递归判断 A.left == B.right
 */
public class IsSymmetrical {
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
    }

}
