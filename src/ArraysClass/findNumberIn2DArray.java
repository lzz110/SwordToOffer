package ArraysClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/10 10:36
 */
public class findNumberIn2DArray {

    /**
     *
     *      剑指 Offer 04. 二维数组中的查找
     *
     *      题目： 在一个 n * m 的二维数组中，每一行都按照从左到右非递减的顺序排序，每一列都按照从上到下非递减的顺序排序。
     *      请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     *      思路： 从左下角开始遍历，
     *      若 flag > target ，则 target 一定在 flag 所在 行的上方 ，即 flag 所在行可被消去
     *      若 flag < target ，则 target 一定在 flag 所在 列的右方 ，即 flag 所在列可被消去
     *

     * @param matrix
     * @param target
     * @return
     */

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i=matrix.length-1,j=0;
        while(i>=0&&j<matrix[0].length){
            if(matrix[i][j]>target){
                i--;
            }else if(matrix[i][j]<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }

}
