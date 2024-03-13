package DynamicProgrammingClass;

/**
 *
 *  题目：leetcode 647. 回文子串
 *
 *  https://leetcode.cn/problems/longest-palindromic-substring/
 *
 *  思路： https://programmercarl.com/
 *      动态规划：
 *             1. 确定dp数组（dp table）以及下标的含义  布尔类型的dp[i][j]：表示区间范围[i,j]
 *                  （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
 *             2. 确定递推公式
 *                  整体上是两种，就是s[i]与s[j]相等，s[i]与s[j]不相等这两种。
 *                  当s[i]与s[j]不相等，那没啥好说的了，dp[i][j]一定是false。
 *                  当s[i]与s[j]相等时，这就复杂一些了，有如下三种情况
 *
 *                      情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
 *                      情况二：下标i 与 j相差为1，例如aa，也是回文子串
 *                      情况三：下标：i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，我们看i到j区间是不是回文子串就看aba是不是回文就可以了，那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
 *                      以上三种情况分析完了，那么递归公式如下：
 *
 *                  if (s[i] == s[j]) {
 *                      if (j - i <= 1) { // 情况一 和 情况二
 *                          result++;
 *                          dp[i][j] = true;
 *                      } else if (dp[i + 1][j - 1]) { // 情况三
 *                          result++;
 *                          dp[i][j] = true;
 *                      }
 *                  }
 */

public class CountSubstrings {

    public int countSubstrings(String s) {
        if(s==null||s.length()<1) return 0;
        int res=0,len=s.length();
        char[] arr=s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(arr[i]==arr[j]){
                    if((j-i)<=1){
                        dp[i][j]=true;
                        res++;
                    }
                    else{
                        if(dp[i+1][j-1]==true){
                            dp[i][j]=true;
                            res++;
                        }else{
                            dp[i][j]=false;
                        }

                    }
                }
            }
        }
        return res;
    }

    /**
     *  LeetCode 5. Longest Palindromic Substring(LeetCode 647. 同一題的思路改一下、加一點，就能通過LeetCode 5)
     *
     */

    public String longestPalindrome(String s) {
        //題目要求要return 最長的回文連續子串，故需要記錄當前最長的連續回文子串長度、最終起點、最終終點。
        int finalStart = 0;
        int finalEnd = 0;
        int finalLen = 0;

        char[] chars = s.toCharArray();
        int len = chars.length;

        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j] && (j - i <= 1 || dp[i + 1][j - 1]))
                    dp[i][j] = true;
                //和LeetCode 647，差別就在這個if statement。
                //如果當前[i, j]範圍內的substring是回文子串(dp[i][j]) 且(&&) 長度大於當前要記錄的最終長度(j - i + 1 > finalLen)
                //我們就更新 當前最長的連續回文子串長度、最終起點、最終終點
                if (dp[i][j] && j - i + 1 > finalLen) {
                    finalLen = j - i + 1;
                    finalStart = i;
                    finalEnd = j;
                }
            }
        }
        //String.substring這個method的用法是[起點, 終點)，包含起點，不包含終點（左閉右開區間），故終點 + 1。
        return s.substring(finalStart, finalEnd + 1);
    }
}
