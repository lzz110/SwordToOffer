package StringClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/21 21:01
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 思路：
 * 当字符串数组长度为 0 时则公共前缀为空，直接返回；
 * 令最长公共前缀 ans 的值为第一个字符串，进行初始化；
 * 遍历后面的字符串，依次将其与 ans 进行比较，两两找出公共前缀，最终结果即为最长公共前缀；
 * 如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回；
 *
 *  注意：
 *  设置两个循环(strsInd, index)，外层循环(strsInd)遍历其余字符串，内层循环(index)遍历当前比较的字符串，
 *  内层循环（index）需要每次在外层更新时进行更新,因此需要设置index = 0 在两层 for 循环之间，
 *  如果设置到外面，index 不会更新，如果设置到第二层里面，第二层for 循环后无法拿到 index 值
 */
public class longestCommonPrefix {



    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        String res = new longestCommonPrefix().longestCommonPrefix(strs);
        System.out.println(res);

    }
    public String longestCommonPrefix(String[] strs) {
        //特判
        if(strs == null || strs.length<1){
            return "";
        }
        String res= strs[0];
        int len=strs.length;
        //
        for(int strsInd=1;strsInd<len;strsInd++){

            int index=0;
            for(;index<res.length()&&index<strs[strsInd].length();index++){
                if(res.charAt(index)!=strs[strsInd].charAt(index)){
                    break;
                }
            }
            res=res.substring(0,index);
            if(res.equals(""))return "";
        }
        return res;
    }

}
