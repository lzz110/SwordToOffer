package MathClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/9 16:00
 *
 *  剑指 Offer 56 - I. 数组中数字出现的次数
 *
 *  一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  输入：nums = [4,1,4,6]
 *  输出：[1,6] 或 [6,1]
 *
 *  输入：nums = [1,2,10,4,1,4,3,3]
 *  输出：[2,10] 或 [10,2]
 */
public class SingleNumbers {

    /*
        思路：这道题，如果看时间复杂度O（n），空间复杂度O（1），其实很好想到异或
             (以前有道题跟这个差不多，只不过有一个不同元素，那个题全员异或就出来了，这个不行)
        前置知识：  1^0 = 1     1^1 = 0   0^0 = 0
                  为啥叫异或，就是如果不同我就返回1，相同我就返回0
                  所以如果有两个数相同  010111 ^ 010111 = 0 异或就为0
        例子： 1 4 6 4 如果全员异或，相同的4肯定没了，留下1 和 6异或的结果，但是光异或我没法返回啊
              哪我就想到了一个很赞的做法
              1 和 6 肯定是不同的吧，异或结果有一位肯定是 1，比如说第2位异或为1
                          => 也就是说 1 和 6 ，第二位一个为1一个为0
              那么我就分组，将第二位为1的分一组，全员异或
                          将第二位为0的分一组，全员异或
              这就是最终结果了
              你可能还有疑问，哪相同的元素怎么办，不会干扰结果吗？
                 当然不会，比如4 和 4，第二位都为0，肯定都被分到一组，最后异或为0，不影响结果
        总结：时间复杂度O(n) 更细就是O(2n)   时间复杂度O(1)
     */

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int h = 1;
        // 细节： == 号实际上是比 & 优先级高的
        while ((h & sum) == 0){
            h <<= 1;
        }
        // 分组
        int group1 = 0, group2 = 0;
        for (int num : nums) {
            if ((num & h) == 0){
                group1 ^= num;
            }else {
                group2 ^= num;
            }
        }
        return new int[]{group1, group2};
    }

}
