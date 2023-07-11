package TreeNodeClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/10 17:06
 */
public class LowestCommonAncestor {

    /**
     *          剑指 Offer 68 - II. 二叉树的最近公共祖先
     *
     *          思路： 自底向上查找，因此想到后序遍历（左右中），
     *                如果找到一个节点，发现左子树出现结点 p，右子树出现节点 q，或者 左子树出现结点 q，右子树出现节点p，那么该节点就是节点p和q的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 递归结束条件
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        }else if(left == null && right != null) { // 若找到一个节点
            return right;
        }else if(left != null && right == null) { // 若找到一个节点
            return left;
        }else { // 若找到两个节点都不为 null ,则返回根节点
            return root;
        }
    }

}
