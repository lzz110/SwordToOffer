package TreeNodeClass;

import java.util.Arrays;

/**
 * 题目：
 *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 *      假设输入的数组的任意两个数字都互不相同。
 *
 * 思路：
 *      根据后续遍历的规律和二叉树具备的特点，可以找到的规律就是（左、右、根）序列的最后一个数为根节点，
 *      根据二叉树的特点，左子节点小于根节点，右子节点大于根节点，分离出左右子节点，
 *      根据上边的规律，递归剩下的序列。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0||sequence==null){
            return false;
        }
        int len=sequence.length;
        int i=0,root=sequence[len-1];
        //先找右子树起点位置
        for(;i<len-1;i++){
            if(sequence[i]>root){
                break;
            }
        }
        //找右子树中是否全部符合大于根节点条件，不满足直接return false
        int j=i;
        for(;j<len-1;j++){
            if(sequence[j]<root)
                return false;
        }

        boolean left=true;
        boolean right=true;
        //Arrays.copyofRange
        //将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。
        //注意这里包括下标from，不包括上标to

        //递归判断左子树是否满足条件
        if(i>0){
            left=VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        //递归判断右子树是否满足条件
        if(i<len-1){
            right=VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,len-1));
        }
        return left&&right;
    }
}
