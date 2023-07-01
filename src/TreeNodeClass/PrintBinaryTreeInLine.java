package TreeNodeClass;

import java.util.*;

/**
 * 题目一：分行从上到下打印二叉树
 *
 * 题目一：实现一个函数按照之字形打印二叉树，
 *          第一行 左  右 的顺序打印，
 *          第二层 右  左 的顺序打印，
 *          第三行 左  右 的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreeInLine {
    public static void main(String[] args) {
        TreeNode rootleft=new TreeNode(6);
        rootleft.setLeft(new TreeNode(5));
        rootleft.setRight(new TreeNode(7));
        TreeNode rootright=new TreeNode(10);
        rootright.setLeft(new TreeNode(9));
        rootright.setRight(new TreeNode(11));
        TreeNode root=new TreeNode(8);
        root.setLeft(rootleft);
        root.setRight(rootright);
//        ArrayList<ArrayList<Integer>> res = new TreeNodeClass.PrintBinaryTreeInLine().Print(root);
        ArrayList<ArrayList<Integer>> res = new PrintBinaryTreeInLine().Print2(root);

        System.out.println(res);
    }

    /**
     * 分行从上到下打印二叉树
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        if(pRoot==null)
            return res;
/*        //剑指思想
        q.add(pRoot);
        int now=1,next=0;
        while(!q.isEmpty()){
            TreeNode t = q.peek();
            tmp.add(t.val);
            if(t.left!=null){
                q.add(t.left);
                next++;
            }
            if(t.right!=null){
                q.add(t.right);
                next++;
            }
            q.poll();
            now--;
            if(now==0){
                res.add(new ArrayList<Integer>(tmp));   //将当前队列的值放在结果中
                tmp.clear();        //清空当前队列
                now=next;
                next=0;
            }

        }
        return res;*/

        //直接将队列的头拿出并删除
        q.add(pRoot);
        int now=1,next=0;
        while(!q.isEmpty()){
            TreeNode t=q.remove();
            now--;
            tmp.add(t.val);
            if(t.left!=null){
                q.add(t.left);
                next++;
            }
            if(t.right!=null){
                q.add(t.right);
                next++;
            }
            if(now==0){
                res.add(new ArrayList<Integer>(tmp));
                tmp.clear();
                now=next;
                next=0;
            }
        }
        return res;
    }

    /**
     * 请实现一个函数按照之字形打印二叉树，
     * 即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推。
     * @param pRoot
     * @return
     *
     * 思路：使用两个栈作为辅助容器。打印某一层节点时，把下一层的子节点保存到栈内。
     * 如果当前打印的是奇数层，则先保存左子树节点再保存右子树节点到第一个栈内；
     * 如果当前打印的是偶数层，则先保存右子树在保存左子树节点到第二个栈内。
     */
    //不记录层数
    public ArrayList<ArrayList<Integer>>Print2(TreeNode pRoot) {
        /*//s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (!s1.empty() || !s2.empty()) {
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if(node != null) {
                        temp.add(node.val);
//                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(new ArrayList<Integer>(temp));
                    temp.clear();
//                    System.out.println();
                }
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if(node != null) {
                        temp.add(node.val);
//                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(new ArrayList<Integer>(temp));
                    temp.clear();
                    System.out.println();
                }
            }
        return list;*/
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)
            return res;
        Stack<TreeNode> stack1=new Stack<>();   //奇数层 先左后右
        Stack<TreeNode> stack2=new Stack<>();   //偶数层 先右后左

        ArrayList<Integer> temp=new ArrayList<>();
        stack1.add(pRoot);
        while(!stack1.empty()||!stack2.isEmpty()){
            while(!stack1.isEmpty()){
                TreeNode t=stack1.pop();
                if(t!=null){    //二叉树节点顺序先左后右
                    temp.add(t.val);
                    if(t.left!=null)
                        stack2.add(t.left);
                    if(t.right!=null)
                        stack2.add(t.right);
                }
            }
            if(!temp.isEmpty()){
                res.add(new ArrayList<Integer>(temp));
                temp.clear();
            }
            while(!stack2.isEmpty()){
                TreeNode t=stack2.pop();
                if(t!=null){    //二叉树先右后左
                    temp.add(t.val);
                    if(t.right!=null)
                        stack1.add(t.right);
                    if(t.left!=null)
                        stack1.add(t.left);
                }
            }
            if(!temp.isEmpty()){
                res.add(new ArrayList<Integer>(temp));
                temp.clear();
            }
        }
        return res;
    }

}
