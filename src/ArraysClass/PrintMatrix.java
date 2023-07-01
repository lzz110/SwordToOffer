package ArraysClass;

import java.util.ArrayList;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *      例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *      则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 思路：定义上下左右边界 并随时更新
 */
public class PrintMatrix {

    public static void main(String[] args) {
//        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[][] arr={{1},{2},{3},{4}};
        int[][] arr={{1}};

        System.out.println(arr.length);
        System.out.println(arr[0].length);
//        ArrayList<Integer> res=new ArrayList<Integer>();
//        res=new PrintMatrix().printMatrix(arr);
//        System.out.println(res);
    }


    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res=new ArrayList<>();
        if(matrix==null||matrix.length==0)
            return res;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int up=0,down=rows-1,left=0,right=cols-1;
        while(up<=down&&left<=right){
            for(int i=left;i<=right;i++){
                res.add(matrix[up][i]);
            }up++;if(up>down) break;
            for(int i=up;i<=down;i++){
                res.add(matrix[i][right]);
            }right--;if(right<left)break;
            for(int i=right;i>=left;i--){
                res.add(matrix[down][i]);
            }down--;if(down<up)break;
            for(int i=down;i>=up;i--){
                res.add(matrix[i][left]);
            }left++;if(left>right)break;
        }
        return res;
    }

















    /*
    public ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> res=new ArrayList<>();
        if(matrix.length==0){
            res.add(0);
            return res;
        }
        int up=0;
        int down=matrix.length-1;
        int left=0;
        if(matrix[0].length==1){        //当只有一列的时候,特殊考虑
            for(int i=0;i<=down;i++){
                res.add(matrix[i][0]);
            }
            return res;
        }
        int right=matrix[0].length-1;   //当只有一列的时候，matrix[0].length=0，
        while(true){
            for(int i = left; i <= right; ++i) res.add(matrix[up][i]); //向右移动直到最右
            if(++ up > down) break; //重新设定上边界，若上边界大于下边界，则遍历完成，下同
            for(int i = up; i <= down; ++i) res.add(matrix[i][right]); //向下
            if(-- right < left) break; //重新设定右边界
            for(int i = right; i >= left; --i) res.add(matrix[down][i]); //向左
            if(-- down < up) break; //重新设定下边界
            for(int i = down; i >= up; --i) res.add(matrix[i][left]); //向上
            if(++ left > right) break; //重新设定左边界
        }
        return res;
    }
    */
}
