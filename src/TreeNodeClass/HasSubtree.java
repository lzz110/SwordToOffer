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

    /*
     参考:数据结构与算法的题解比较好懂
     死死记住isSubStructure()的定义:判断B是否为A的子结构
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 若A与B其中一个为空,立即返回false
        if(A == null || B == null) {
            return false;
        }
        // B为A的子结构有3种情况,满足任意一种即可:
        // 1.B的子结构起点为A的根节点,此时结果为recur(A,B)
        // 2.B的子结构起点隐藏在A的左子树中,而不是直接为A的根节点,此时结果为isSubStructure(A.left, B)
        // 3.B的子结构起点隐藏在A的右子树中,此时结果为isSubStructure(A.right, B)
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /*
    判断B是否为A的子结构,其中B子结构的起点为A的根节点
    */
    private boolean recur(TreeNode A, TreeNode B) {
        // 若B走完了,说明查找完毕,B为A的子结构
        if(B == null) {
            return true;
        }
        // 若B不为空并且A为空或者A与B的值不相等,直接可以判断B不是A的子结构
        if(A == null || A.val != B.val) {
            return false;
        }
        // 当A与B当前节点值相等,若要判断B为A的子结构
        // 还需要判断B的左子树是否为A左子树的子结构 && B的右子树是否为A右子树的子结构
        // 若两者都满足就说明B是A的子结构,并且该子结构以A根节点为起点
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
