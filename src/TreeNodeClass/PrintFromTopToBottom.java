package TreeNodeClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 题目：从上到下打印二叉树
 *
 * 思路：打印根节点 将子节点放入队列 循环执行 直至队列为空
 *
 * 注意：用LinkedList 模拟队列 因为要 remove(0) 所以用 LinkedList 比 ArrayList 更快
 */
public class PrintFromTopToBottom {
    public static void main(String[] args) {
        TreeNode mytreenodeleft=new TreeNode(6);
        mytreenodeleft.setLeft(new TreeNode(5));
        mytreenodeleft.setRight(new TreeNode(7));

        TreeNode mytreenoderight=new TreeNode(10);
        mytreenoderight.setLeft(new TreeNode(9));
        mytreenoderight.setRight(new TreeNode(11));

        TreeNode root=new TreeNode(8);
        root.setLeft(mytreenodeleft);
        root.setRight(mytreenoderight);

        ArrayList<Integer> res=new PrintFromTopToBottom().PrintFromTopToBottom(root);
        Iterator it=res.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+"   ");
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        //用LinkedList 模拟队列 因为要remove 所以用LinkedList比ArrayList更快
        if (root == null) {
            return list;
        }
        queue.add(root);
        while(queue.size()!=0){
            TreeNode temp=queue.remove(0);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            list.add(temp.val);
        }
        return list;
    }
}
