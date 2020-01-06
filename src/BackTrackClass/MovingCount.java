package BackTrackClass;

/**
 * 题目：
 *      有一个m行和n列的方格。一个机器人从坐标（0,0）的格子开始移动，
 *      每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 思路：
 *      回溯算法--递归
 *                创建相同大小的 boolean 数组
 *        递归函数：
 *                先写递归退出条件
 *                进入递归之前 将该位置 true 表示已走过
 *                然后写递归函数
 *                进入递归之后 将该位置 false 表示未走过 等待再次进入
 */

public class MovingCount {
   public static void main(String[] args) {
//       System.out.println(new BackTrackClass.MovingCount().movingCount(15,20,20));
       System.out.println(new MovingCount().movingCount(2,3,3));
   }




    int count=0;
    public int movingCount(int threshold, int rows, int cols) {
       boolean[] flag=new boolean[rows*cols];
       movingCount(threshold,0,0,rows,cols,flag);
       return count;
    }

    private void movingCount(int threshold, int i, int j,int rows, int cols,boolean[] pass){
        int index=i*cols+j;
        //递归退出条件
        if(i<0||j<0||i>=rows||j>=cols||pass[index]||helper(i,j)>threshold)
            return;
        if(helper(i,j)<=threshold){
            count++;
            pass[index]=true;
        }
        movingCount(threshold,i-1,j,rows,cols,pass);
        movingCount(threshold,i,j-1,rows,cols,pass);
        movingCount(threshold,i+1,j,rows,cols,pass);
        movingCount(threshold,i,j+1,rows,cols,pass);

    }
    private int helper(int i,int j){
        int sum=0;
        while(i>0){
            sum+=i%10;
            i/=10;
        }
        while(j>0){
            sum+=j%10;
            j/=10;
        }
        return sum;

    }

}
