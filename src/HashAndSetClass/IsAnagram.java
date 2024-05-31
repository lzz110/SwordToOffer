package HashAndSetClass;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/24 14:07
 */
public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        new IsAnagram().isAnagram(s,t);
        System.out.println('a');
    }

    /*
     * @lc app=leetcode.cn id=242 lang=java
     *
     * [242] 有效的字母异位词
     *  若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
     *
     *  思路： 创建一个hash 数组，将 s 和 t 中的每个字符分别做 + 和 - 的操作，之后判断数组元素是否为 0，全为0时，是一个有效的字母异位词
     *      
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;

        }
        for (int i = 0; i < hash.length; i++) {
            if(hash[i]!=0) return false;
        }

        return true;

    }

    /*
     * @lc app=leetcode.cn id=1002 lang=java
     *
     * [1002] 查找共用字符
     *   给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。
     *   
     *    思路： 找出每个字符在所有字符串中最少出现的次数。
     *       初始化 minFreq 数组的大小为 26（因为英文字母有 26 个），并将其所有元素设置为 Integer.MAX_VALUE。
     *       如果某个字符在某一个字符串中没有出现，那么它在 minFreq 数组中的对应值就会保持为初始值 Integer.MAX_VALUE，因此最终不会出现在结果中
     *   
     *   Q: 在结果进行遍历的时候，为什么要有两层循环？
     *   A: 例如，字符 'l' 在所有字符串中至少出现了两次，所以结果列表中应该包含两个 'l'。
     *   统计字符串中每个字母出现的次数
     *      int[] current=new int[26];
     *      for(char c:word.toCharArray()){
     *           current[c-'a']++;
     *      }
     * 
     */
    public List<String> commonChars(String[] words) {
        int[] minArray = new int[26];
        for(int i=0;i<minArray.length;i++){
            minArray[i]=Integer.MAX_VALUE;    
        }
        for(String word:words){
            int[] count=new int[26];
            for(char ch:word.toCharArray()){
                count[ch-'a']++;
            }
            for(int i=0;i<26;i++){
                minArray[i]=Math.min(minArray[i],count[i]);
            }
        }
        List<String> res= new ArrayList<>();
        for(int i=0;i<26;i++){
            for(int j=0;j<minArray[i];j++){
                res.add(String.valueOf((char)(i+'a')));
            }
        }
        return res;
    }

    /*
     * @lc app=leetcode.cn id=349 lang=java
     *
     * [349] 两个数组的交集
     *  
     *  题目：求两个数组的交集，即找出两个数组中都出现的元素，返回这些元素组成的数组。
     *
     *  思路：
     *       使用 HashSet 存储第一个数组的所有元素。
     *       遍历第二个数组，检查每个元素是否在 HashSet 中，如果在，则将其添加到结果集中。
     *       将结果集 HashSet 转换为整数数组返回。
     *  注意： 将 HashSet<Integer> 数组 转换为 整数数组： res.stream().mapToInt(Integer::intValue).toArray();
     *       
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null && nums2==null) return new int[]{0};
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        HashSet<Integer> res= new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        // 方法一：使用 Java 8 中的流式操作来将 HashSet 中的元素转换为整数数组
        return res.stream().mapToInt(Integer::intValue).toArray();
        // 方法二：通过遍历 HashSet，手动将元素一个个地添加到 int 数组中
        // int[] res = new int[resSet.size()];
        // int i = 0;
        // for (Integer num : resSet) {
        //     res[i++] = num;
        // }
        // return res;
    }


    /**
     *
     * 202. 快乐数
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」 定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。  如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     *
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     *
     *
     * 输入：n = 2  输出：false
     *
     * @return
     */
    public boolean isHappy(int n) {

        HashSet<Integer> hashset = new HashSet<>();
        while(n!=1&& !hashset.contains(n)) {  //!hashset.contains(n) 就是用来判断 如果 n =2 无线循环这种情况的
            hashset.add(n);
            n=getNextNumber(n);
        }
        return n==1;
    }

    private int getNextNumber(int n) {
        int res=0;
        while(n!=0){
            int temp = n%10;
            res=temp*temp;
            n/=10;
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res= new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target- nums[i])){
                res[0]=i;
                res[1]=map.get(target- nums[i]);
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count=0;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                int sum = nums1[i]+ nums2[j];
                map.put(sum, map.getOrDefault(sum,0)+1);

            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if(map.containsKey(0-nums3[i]-nums4[j])){
                    count+=map.getOrDefault(0-nums3[i]-nums4[j],0);
                }
            }
        }

        return count;
    }
}
