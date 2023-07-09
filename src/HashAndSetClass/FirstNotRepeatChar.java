package HashAndSetClass;

import java.util.HashMap;

/**
 * 题目：
 *      在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 *      并返回它的位置,如果没有则返回 -1（需要区分大小写）
 *
 * 思路：创建hashmap 存储，存储的是false 和 true， 而不是 存在的次数，
 *
 * 注意：
 *      0：48  A:65 a:97
 */
public class FirstNotRepeatChar {
    public static void main(String[] args) {
        String str="loveleetcode";
//        int res=Integer.MAX_VALUE;
//        System.out.println(str.charAt(0)-'0');
        System.out.println(new HashAndSetClass.FirstNotRepeatChar().firstUniqChar(str));
    }

    //创建hashmap 存储，存储的是false 和 true， 而不是 存在的次数，
    //对于sc中的每个字符c，如果dic中已经包含了c作为键，就将其对应的值设为false；如果dic中没有包含c作为键，就将其对应的值设为true。
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }


}
