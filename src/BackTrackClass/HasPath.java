package BackTrackClass;

/**
 * 题目：判断在一个矩阵中是否存在一条包含某字符串所有字符的路径 可以在矩阵中向 左 右 上 下 移动一个格子
 *      如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *
 * 思路：回溯思想--递归
 *       创建相同大小的 boolean 数组
 *      递归函数：
 *                先写递归退出条件
 *                进入递归之前 将该位置 true 表示已走过
 *                然后写递归函数
 *                进入递归之后 将该位置 false 表示未走过 等待再次进入
 */

public class HasPath {
    public static void main(String[] args) {
        char[] matrix= {'a','b','c','e','s','f','c','s','a','d','e','e'};
//        char[] str={'b','c','c','e','a'};
        char[] str={'a','b','c','e'};
        System.out.println(new HasPath().hasPath(matrix,3,4,str));


    }


   public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //创建相同形状的 boolean 数组
        boolean[] flag=new boolean[matrix.length];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(judge(matrix,i,j,rows,cols,flag,str,0))
                    return true;
            }
        }
        return false;
    }

    private boolean judge(char[] matrix,int i,int j,int rows,int cols,boolean[] flag,char[] str,int k){
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i*cols+j;
        //递归终止条件
        if(i<0 || j<0 || i>=rows || j>=cols || matrix[index] != str[k] || flag[index] == true)
            return false;
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if(k == str.length-1)
            return true;

        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if(judge(matrix,i-1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i+1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j-1,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j+1,rows,cols,flag,str,k+1)  )
        {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }




}
