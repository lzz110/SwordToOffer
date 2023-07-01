package DoublePointer;

import java.util.*;
/**
 *
 * start不动，end向后移动
 * 当end遇到重复字符，start应该放在上一个重复字符的位置的后一位，同时记录最长的长度
 * 怎样判断是否遇到重复字符，且怎么知道上一个重复字符的位置？--用哈希字典的key来判断是否重复，用value来记录该字符的下一个不重复的位置。
 *
 * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
 * 我们定义不重复子串的开始位置为 start，结束位置为 end
 * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
 * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
 *
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        //先写特判
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int end = 0, start = 0; end < n; end++) {  //注意是end < n
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha)+1, start);  //当end遇到重复字符，start应该放在上一个重复字符(可能是当前字符map.get(alpha)， 也可能是start,所以需要取他俩的最大值)的位置的后一位，同时记录最长的长度
            }
            map.put(s.charAt(end), end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
    

}
