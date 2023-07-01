package ArraysClass;
import java.util.*;
/**
 * 题目：最长不含重复字符的子字符串 返回其长度
 *
 * 思路：
 *
 *      定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
 *      我们定义不重复子串的开始位置为 start，结束位置为 end
 *      随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
 *      无论是否更新 start，都会更新其 map 数据结构和结果 ans。
 *
 *
 *      start不动，end向后移动
 *      当end遇到重复字符，start应该放在上一个重复字符(上一个重复字符 可能是当前的 map.get(alpha) ， 也可能是 start) 的位置的后一位，同时记录最长的长度
 *      怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？--用哈希字典的key来判断是否重复，用value来记录该字符的下一个不重复的位置。
 *
 *
 * 动态规划
 *			首先定义函数f(i)表示以第i个字符为结尾的不包含重复字符的子字符串的最长长度,则有一下三种情形
 *   		1）第i个字符在之前都没有出现过，则f(i) = f(i-1)+1
 *   		2）第i个字符在之前出现过，但是在f(i-1)这个子串的前面出现过，则最长还是f(i-1)+1
 *			3）第i个字符在之前出现过，不过在f(i-1)的这个子串的中间出现过，则f(i)=这两个重复字符的中间值 即i - prevIndex
 *         d<=f(i-1) f(i)=d
 *         d>f(i-1)  f(i)=f(i-1)+1
 *
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
//        String s="abcabcbb";

        String s="a";
        for(Character ch: s.toCharArray()){

        }

        System.out.println(s.substring(0,0));
//        System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s)
    {
        if(s==null || s.length()==0){
            return 0;
        }
        Map<Character, Integer> hashmap=new HashMap<>();
        int len= s.length(); int res=0;
        for(int start=0,end=0;end<len;end++){
            Character ch=s.charAt(end);
            if(hashmap.containsKey(ch)){
                //注意：要+1
                start= Math.max(hashmap.get(ch)+1,start);
            }
            hashmap.put(ch,end);
            res=Math.max(res,end-start+1);
        }
        return res;
    }


/*
    public int ArraysClass.lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        int left = 0;
        // 非空的时候，结果至少是 1 ，因此初值可以设置成为 1
        int res = 1;
        //  key 为字符，val 记录了当前读到的字符的索引，在每轮循环的最后更新
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < len; right++) {
            // 右边界没有重复的时候，直接向右边扩张就好了
            // 右边界有重复的时候，只要在滑动窗口内，我们就得更新
            // 如果在滑动窗口之外，一定是之前被计算过的
            if (map.containsKey(s.charAt(right))) {
                //判断当前字符的索引是否在滑动窗口内，如果满足，将滑动窗口的左边界设置到重复的那个位置之后
                if (map.get(s.charAt(right)) >= left) {
                    // 下一个不重复的子串至少在之前重复的那个位置之后
                    // 【特别注意】快在这个地方，左边界直接跳到之前重复的那个位置之后
                    left = map.get(s.charAt(right)) + 1;
                }
            }
            // 此时滑动窗口内一定没有重复元素
            res = Math.max(res, right - left + 1);
            // 无论如何都更新位置
            map.put(s.charAt(right), right);
        }
        return res;

    }
*/

}
