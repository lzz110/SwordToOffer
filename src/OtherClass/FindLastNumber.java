package OtherClass;

/**
 * 题目：n个人 第m个数 找出最后剩的人
 * 思路：
 *      方法一：循环遍历删除
 *      方法二：数学归纳法 f(n,m)=[f(n-1,m)+m]%n
 */
public class FindLastNumber {
    public static void main(String[] args) {

        System.out.println(new FindLastNumber().LastRemainingNumber(5,3));
    }

    //最正常的思路 --循环遍历删除
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