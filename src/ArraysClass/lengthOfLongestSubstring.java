package ArraysClass;

/**
 * 题目：最长不含重复字符的子字符串 返回其长度
 *
 * 思路：动态规划
 *			首先定义函数f(i)表示以第i个字符为结尾的不包含重复字符的子字符串的最长长度,则有一下三种情形
 *   		1）第i个字符在之前都没有出现过，则f(i) = f(i-1)+1
 *   		2）第i个字符在之前出现过，但是在f(i-1)这个子串的前面出现过，则最长还是f(i-1)+1
 *			3）第i个字符在之前出现过，不过在f(i-1)的这个子串的中间出现过，则f(i)=这两个重复字符的中间值 即i - prevIndex
 *         d<=f(i-1) f(i)=d
 *         d>f(i-1)  f(i)=f(i-1)+1
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(new lengthOfLongestSubstring().lengthOfLongestSubstring(s));
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
    public int lengthOfLongestSubstring(String str)
    {
        int curLength = 0;
        int maxLength = 0;

        int[] position = new int[26];
        for(int i = 0; i < 26; ++i)
            position[i] = -1;

        for(int i = 0; i < str.length(); ++i)
        {
            int prevIndex = position[str.charAt(i) - 'a'];
            if(prevIndex < 0 || i - prevIndex > curLength)
                ++curLength;
            else
            {
                if(curLength > maxLength)
                    maxLength = curLength;

                curLength = i - prevIndex;
            }
            position[str.charAt(i) - 'a'] = i;
        }

        if(curLength > maxLength)
            maxLength = curLength;

        return maxLength;
    }
}
