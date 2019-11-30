package TreeNodeClass;

import java.util.ArrayList;

/**
 * 题目：输入一颗二叉树的 根节点 和 一个整数，打印出二叉树中结点值的和为输入整数的所有路径
 *
 * 思路：
 *      1、找规律：**需要遍历树的所有结点：我们会想到前、中、后遍历
 *
 * ​      需要存储遍历过的路径（节点值）：我们想到用数组存储
 *
 *      2、算法思想：前序遍历（根、左、右）的特点，从根到叶子节点，所有可能的路径都会遍历到，所以使用前序遍历更佳。
 *
 *        每遍历一个结点就将其累加，然后判断累加的值是否等于目标值且子节点为叶子节点。
 *
 *         如果是，则打印输出该路径； 如果不是，则回退到上一父节点，
 *
 *         此时数组中的数据结点进行删除，然后不断的遍历下一子节点，递归。
 *
 *      3、综上所述，**存储结点路径的时候，涉及到累加结点和删除节点，我们可以将其抽象成入栈和出栈。
 *
 *         然后遍历二叉树的所有路径可以用到递归的过程，让出栈和入栈与递归的状态达成一致.
 *
 */
public class FindPath {
    public static void main(String[] args) {
        TreeNode rootleft=new TreeNode(5);
        rootleft.setLeft(new TreeNode(4));
        rootleft.setRight(new TreeNode(7));
        TreeNode rootright=new TreeNode(12);
        TreeNode root=new TreeNode(10);
        root.setLeft(rootleft);
        root.setRight(rootright);

        FindPath findPath=new FindPath();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        res=findPath.FindPath(root,22);
        System.out.println(res);
    }

    //listAll 和 list 要放在外面 否则放在里面递归的过程中会重新 new 一个，会把上一步结果覆盖
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root==null)      //递归退出条件
            return listAll;

        list.add(root.val);     //先走根节点
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));        //如果不new一个 后面remove 会把结果list 里面的减掉
            //new 只是把当前的结果 list 重新封装成一个新的 list 传给listAll
//            listAll.add(list);
        FindPath(root.left, target);        //再走左子节点
        FindPath(root.right, target);       //再走右子节点
        list.remove(list.size()-1);   //回溯思想 把当前结果中最后一步的结果删除 回退到上一步
        return listAll;
    }
}
