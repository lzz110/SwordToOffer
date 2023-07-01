package TreeNodeClass;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 *
 * 思路： 递归调用 核心函数（pre ,preStart,preEnd,in,inStart,inEnd）
 *
 * 注意： 递归的 前序 和 中序 的 头节点和尾节点
 *
 */
public class ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre={1,2,4,7,3,5,6,8};
        int[] in={4,7,2,1,5,3,8,6};

        TreeNode res=new ReConstructBinaryTree().reConstructBinaryTree(pre,in);
        res.preOrderTraverse(res);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTreeCore(pre,0,pre.length-1,
                                                in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTreeCore(int [] pre,int startPre,int endPre,
                                               int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)      //递归退出条件
            return null;
        TreeNode root=new TreeNode(pre[startPre]);  //给当前根节点创建一棵树 递归返回
        for(int i=startIn;i<=endIn;i++)     //注意 i<=endIn
            if(in[i]==pre[startPre]){   //在 中序遍历 中找 前序遍历 的根节点
                //[startIn,i] 是i这个元素的左孩子及其子节点
                // i是中序遍历的根节点 startPre 是前序遍历的根节点
                root.left=reConstructBinaryTreeCore(pre,startPre+1,startPre+(i-startIn),
                                                    in,startIn,i-1);
                root.right=reConstructBinaryTreeCore(pre,startPre+(i-startIn)+1,endPre,
                                                    in,i+1,endIn);
                break;
            }

        return root;
    }

    // 叶子数
    private  static int leafNum(TreeNode node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                return 1;
            }
            return leafNum(node.left) + leafNum(node.right);
        }
        return 0;
    }

}
