package ArraysClass;
import java.util.*;
/**
 * 题目：最长不含重复字符的子字符串 返回其长度
 *
 * 思路： 滑动窗口

*             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
*              此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；
*
*             2、如果当前字符 ch 包含在 map中，此时有2类情况：
*              1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
*              那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
*              2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
*              而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
*              随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
*              应该不变，left始终为2，子段变成 ba才对。
*
*              为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
*              另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
*              因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
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

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

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
