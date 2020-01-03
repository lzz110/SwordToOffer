package TreeNodeClass;

/**
 *
 * 题目：给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，
 * 按结点数值大小顺序第三小结点的值为4。

解析：中序遍历
	 必须要对每一个递归调用返回值进行判断  if(node != null) {return node;}，
     判断返回值是否为null，如果为null就说明没找到，要继续执行 index++ ; if(index == k){...}的寻找过程，
     如果返回不为空，则说明在递归调用判断子节点的时候已经找到符合要求的节点了，则将找到的节点
     逐层向上传递返回。直到返回到第一次调用 KthNode 的地方。
     如果不对递归调用的返回值做判断，即不执行 if(node != null){return node;}，
     那所找到符合 要求的节点只能返回到上一层，不能返回到顶层
 */
public class KthNode {
    public static void main(String[] args) {
        TreeNode rootleft=new TreeNode(6);
        rootleft.setLeft(new TreeNode(5));
        rootleft.setRight(new TreeNode(7));

        TreeNode root=new  TreeNode(8);
        root.setLeft(rootleft);
        TreeNode treeNode = new KthNode().KthNode(root, 3);
        System.out.println(treeNode.val);
    }
    int index = 0; //计数器
    TreeNode KthNode(TreeNode root, int k)
    {
        if(root==null||k==0)
            return null;
        if(root!=null){
            TreeNode node=KthNode(root.left,k);
            if(node!=null)
                return node;
            index++;
            if(index==k){
                return root;
            }
            node=KthNode(root.right,k);
            if(node!=null)
                return node;
        }
        return null;
    }
}
