package TreeNodeClass;

/**
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树
 * 例如：	    1
 *			2		3
 *		4		 5     6
 * 结果：1,2,4,#,#,#,3,5,#,#,6,#,#,(前序遍历)
 *  
 * 思路：
 *      序列化  ：遍历二叉树，遇到叶子节点，将其转化为 $ 表示。
 *      反序列化：根据前序遍历的特点（根、左、右），进行二叉树的还原
 */
public class SerializeAndDeserialize {
    public static void main(String[] args) {
        TreeNode rootleft=new TreeNode(2);
        rootleft.setLeft(new TreeNode(4));
        TreeNode rootright=new TreeNode(3);
        rootright.setLeft(new TreeNode(5));
        rootright.setRight(new TreeNode(6));
        TreeNode root=new  TreeNode(1);
        root.setLeft(rootleft);
        root.setRight(rootright);


        String serialize = new SerializeAndDeserialize().Serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = new SerializeAndDeserialize().Deserialize(serialize);
        root.preOrderTraverse(deserialize);
    }
    public int index = -1;
    String Serialize(TreeNode root) {
        StringBuffer sb=new StringBuffer();
        if(root==null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    
	TreeNode Deserialize(String str) {
        index++;
        int len=str.length();
        TreeNode node=null;
        if(index>=len){
            return null;
        }
        String[] splitstr = str.split(",");
        if(!splitstr[index].equals("#")){
            node=new TreeNode(Integer.parseInt(splitstr[index]));	//将String[] 的单个字符转换成int 存入TreeNode中
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;
    }

}
