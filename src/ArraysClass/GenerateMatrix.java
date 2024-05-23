package ArraysClass;
import java.util.*;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/23 14:13
 * 题目：
 *      59. 螺旋矩阵 II
 *      给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 思路：
 *      生成一个 n×n 空矩阵 mat，随后模拟整个向内环绕的填入过程：
 *      定义当前左右上下边界 l,r,t,b，初始值 num = 1，迭代终止值 tar = n * n；
 *      当 num <= tar 时，始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环，每次填入后：
 *          执行 num += 1：得到下一个需要填入的数字；
 *          更新边界：例如从左到右填完后，上边界 t += 1，相当于上边界向内缩 1。
 *      使用num <= tar而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
 *
 *  注意： 定义边界时，right = n-1，bottom=n-1 ，因为后续要指定 right 为二维数组中的index 
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{4,5,6,0},{7,8,9,0}};
        System.out.println(matrix[0].length);
        System.out.println(matrix.length);



    }

    public int[][] generateMatrix(int n) {
        int[][] mat= new int[n][n];

        int number =1,left = 0, right = n-1,top =0, bottom =n-1,tar = n*n;
        while(number<=tar){
            for(int i=left;i<=right;i++){
                mat[top][i]= number++;
            }
            top++;
            for(int i= top;i<=bottom;i++){
                mat[i][right]= number++;
            }
            right--;
            for(int i=right;i>=left;i--){
                mat[bottom][i]=number++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                mat[i][left]=number++;
            }
            left++;
        }
        return mat;
    }

    //
    public List<Integer> spiralOrder(int[][] matrix) {

        int left = 0, right = matrix[0].length-1, top=0, bottom = matrix.length-1;
        List<Integer> res= new ArrayList<Integer> ();
        while(true){
            for(int i=left;i<=right;i++){
                res.add(matrix[left][i]);
            }
            top++;
            if(top>bottom)break;
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(right<left)break;
            for(int i=right;i>=left;i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom)break;
            for(int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;
            if(left>right)break;
        }
        return res;
    }
}
