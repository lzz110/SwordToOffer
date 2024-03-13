package GreedyClass;

/**
 *  题目： 738. 单调递增的数字
 *
 *  思路：
 *        贪心思想
 *        从后向前遍历，就可以重复利用上次比较得出的结果了，从后向前遍历332的数值变化为：332 -> 329 -> 299
 *        flag用来标记赋值9从哪里开始
 *        设置为这个默认值，为了处理像 1000 这样的数字，如果仅仅将 arr[i]=9 那结果是900 ，而不是999
 *        flag 初始值 应该等于 n.length, 而不是0， 如果是0的话，1234 将变成9999
 *
 */

public class monotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int n) {
        String s= String.valueOf(n);
        char[] arr= s.toCharArray();
        int len = s.length(),flag = len;
        for(int i=len-1;i>0;i--){
            if(arr[i-1]>arr[i]){
                arr[i-1]--;
                flag=i;
            }
        }
        for(int i=flag;i<len;i++){
            arr[i]='9';
        }
        return Integer.parseInt(String.valueOf(arr));
    }
}
