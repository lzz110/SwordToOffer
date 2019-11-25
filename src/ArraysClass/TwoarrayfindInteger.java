package ArraysClass;

/**
 * 题目：
 *      在一个二维数组中（每个一维数组的长度相同），
 *      每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *      请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：
 *      定位到数组的 左下 或者 右上
 *      退出循环条件：row 或者 col 超出边界
 * 注意：
 *      求二维数组行和列
 *       int rows=array.length;
 *       int cols=array[0].length;
 */
public class TwoarrayfindInteger {
    public static void main(String[] args) {
//        System.out.println(111);
        int[][] array={
                {2,3,4},
                {4,5,6},
                {7,8,9},
        };
        int target=10;
        boolean res=new TwoarrayfindInteger().Find(target,array);
        System.out.println(res);
    }

    public boolean Find(int target, int [][] array) {
        if(array.length==0||array==null)
            return false;
        int rows=array.length;
        int cols=array[0].length;

        //定位到右上
        int row=0,col=cols-1;
        while(row<rows&&col>=0){
            if(array[row][col]>target){
                col--;
            }else if(array[row][col]<target){
                row++;
            }else
                return true;
        }
        return false;
    }



    /*private  boolean Find(int target, int [][] array) {
        int rows=array.length;
        if(rows==0)
            return false;
        int cols=array[0].length;
        //从右上开始查找，注意while里面行和列的范围，要缩小
        int row=0,col=cols-1;
        while(row<rows && col>=0){
            if(array[row][col]<target){
                row++;
            }else if(array[row][col]>target){
                col--;
            }else{
                return true;
            }
        }
        //从左下开始查找，注意while里面行和列的范围，要缩小
        *//*int row=rows-1,col=0;
        while(row>=0 && col<cols){
            if(array[row][col]<target){
                col++;
            }else if(array[row][col]>target){
                row--;
            }else{
                return true;
            }
        }*//*
        return false;
    }*/
}
