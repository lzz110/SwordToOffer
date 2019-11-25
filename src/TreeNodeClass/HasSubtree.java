package TreeNodeClass;

import TreeNodeClass.TreeNode;

/**
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。
 * 思路：
 *      第一步：在 A 中找到 和 B 的根节点值一样的节点 result
 *      第二步：判断 A 子树 == B 子树
 * 注意：
 *      两个递归
 *      一个是递归查找 A中 与 B的根节点值 一样的节点
 *      一个是递归 遍历 B 子树
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result =false;
        if(root1!=null&&root2!=null) {
            if (root1.val == root2.val) {
                result = DoesTree1HasTree2(root1, root2);
            }
            if(!result)
                result=HasSubtree(root1.left,root2);
            if(!result)
                result=HasSubtree(root1.right,root2);

        }
        return result;
    }

    public boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2!=null){
            return false;
        }
        if(root2==null)
            return true;
        if(root1.val!=root2.val)
            return false;
        return DoesTree1HasTree2(root1.left,root2.left) && DoesTree1HasTree2(root1.right,root2.right);
    }
}
