package ArraysClass;

public class GetMaxValue {
/**
 *
 * 题目：寻找二维数组路径最大值
 *
 *
 */
    public static void main(String[] args) {
        //int[]values={1,10,3,8,12,2,9,6,5,7,4,11,3,7,16,5};
        int[][] values = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(new GetMaxValue().getMaxvalue(values));
//        int[][] values1 = {{1, 10, 3, 8}};
//        System.out.println(new ArraysClass.GetMaxValue().getMaxvalue(values1));  //22
//        int[][] values2 = {{1}, {1}, {5}, {3}};
//        System.out.println(new ArraysClass.GetMaxValue().getMaxvalue(values2));  //10
//        System.out.println("-------------");
//        int[][] values3 = {};
//        System.out.println(new ArraysClass.GetMaxValue().getMaxvalue(values3));
    }

    public int getMaxvalue(int[][] values){
        if(values==null)
            return 0;
        int rows=values.length;
            if(rows==0)return 0;
        int cols=values[0].length;

        //int[][] maxvalues=new int[rows][cols];
        int[] maxvalues=new int[cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int up=0;
                int left=0;
                if(i>0)
                    //up=maxvalues[i-1][j];
                    up=maxvalues[j];
                if(j>0)
//                   left=maxvalues[i][j-1];
                    left=maxvalues[j-1];
//                maxvalues[i][j]=Math.max(up,left)+values[i][j];
                maxvalues[j]=Math.max(up,left)+values[i][j];
            }
        }
//        return maxvalues[rows-1][cols-1];
        return maxvalues[cols-1];
    }


}
