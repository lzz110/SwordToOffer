package TreeNodeClass;

import java.util.*;

/**
 * 题目：输入一颗二叉树的 根节点 和 一个整数，打印出二叉树中结点值的和为输入整数的所有路径
 *
 * 思路：
 *      1、找规律：**需要遍历树的所有结点：我们会想到前、中、后遍历
 *
 *        需要存储遍历过的路径（节点值）：我们想到用数组存储
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

        FindPath(root.left, target);        //再走左子节点
        FindPath(root.right, target);       //再走右子节点
        list.remove(list.size()-1);   //回溯思想 把当前结果中最后一步的结果删除 回退到上一步
        return listAll;
    }

    /**
     *      112. 路径总和
     *
     *      思路：递归+回溯，
     *          因为终止条件是判断叶子节点，所以递归的过程中就不要让空节点进入递归了。
     *          递归函数是有返回值的，如果递归函数返回true，说明找到了合适的路径，应该立刻返回
     *
     * @param root
     * @param targetSum
     * @return
     */

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return traversal(root, targetSum - root.val);
    }

    boolean traversal(TreeNode cur, int count) {
        if (cur.left==null && cur.right==null && count == 0) return true; // 遇到叶子节点，并且计数为0
        if (cur.left==null && cur.right==null) return false; // 遇到叶子节点,并且计数不为0直接返回

        if (cur.left!=null) { // 左
            count -= cur.left.val; // 递归，处理节点;
            if (traversal(cur.left, count)) return true;
            count += cur.left.val; // 回溯，撤销处理结果
        }
        if (cur.right!=null) { // 右
            count -= cur.right.val; // 递归，处理节点;
            if (traversal(cur.right, count)) return true;
            count += cur.right.val; // 回溯，撤销处理结果
        }
        return false;
    }

    public List<List<Integer>> pathsum(TreeNode root, int targetsum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; // 非空判断

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetsum, res, path);
        return res;
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root ==null) return new ArrayList<>(0);
        List<List<Integer>> res= new ArrayList<>();
        if(root ==null) return null;
        List<Integer> path = new LinkedList<>();
        preorderdfs(root,target,res,path);
        return res;
    }

    public void preorderdfs(TreeNode root, int target,List<List<Integer>> res, List<Integer> path){
        path.add(root.val);
        if(root.left == null && root.right ==null){
            if(target -root.val ==0){
                res.add(new ArrayList<>(path));
            }
            return ;
        }

        if(root.left!=null){
            preorderdfs(root.left,target-root.val,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            preorderdfs(root.right,target-root.val,res,path);
            path.remove(path.size()-1);
        }

    }

}
