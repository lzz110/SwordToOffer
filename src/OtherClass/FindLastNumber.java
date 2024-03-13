package OtherClass;

/**
 * 题目：n个人 第m个数 找出最后剩的人
 * 思路：
 *      方法一：循环遍历删除
 *      方法二：数学归纳法 f(n,m)=[f(n-1,m)+m]%n
 *
 *          第一轮后面的数字应该是[0, 1, 2 ,3 ,4]  n=5,m=3
 *          最后剩下的数字是 3 , 下标是 0
 *          第四轮反推，补上 m 个位置，然后模上当时的数组大小 2，位置是(0 + 3) % 2 = 1。
 *          第三轮反推，补上 m 个位置，然后模上当时的数组大小 3，位置是(1 + 3) % 3 = 1。
 *          第二轮反推，补上 m 个位置，然后模上当时的数组大小 4，位置是(1 + 3) % 4 = 0。
 *          第一轮反推，补上 m 个位置，然后模上当时的数组大小 5，位置是(0 + 3) % 5 = 3。
 *          所以最终剩下的数字的下标就是3。因为数组是从0开始的，所以最终的答案就是3。
 *          总结一下反推的过程，就是 (当前index + m) % 上一轮剩余数字的个数。
 */
public class FindLastNumber {
    public static void main(String[] args) {

        System.out.println(new FindLastNumber().LastRemainingNumber(5,3));
    }

    //最正常的思路 --循环遍历删除   测试会超时
    public int LastRemainingNumber(int n,int m){
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count>0){                     //跳出循环时将最后一个元素也设置为了-1
            i++;                            //指向上一个被删除对象的下一个元素。
            if(i==n) i=0;                   //模拟环。
            if(array[i] == -1) continue;    //跳过被删除的对象。
            step++;                         //记录已走过的步数。
            if(step==m) {             //找到待删除的对象。不能写成 m=m%n 如果m==n m%n==0 会进入死循环;
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;                       //返回跳出循环时的i,即最后一个被设置为-1的元素
    }
/*
    //数学归纳法 f(n,m)=[f(n-1,m)+m]%n
    public int LastRemainingNumber(int n,int m){
        if(n<1||m<1) return -1;
        int last=0;
        for(int i=2;i<=n;i++){      //注意i<=n
            last=(last+m)%i;
        }
        return last;
    }
*/
}