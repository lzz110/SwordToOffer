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
        return res.stream().mapToInt(Integer::intValue).toArray();
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
