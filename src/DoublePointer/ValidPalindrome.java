package DoublePointer;

/**
 * 题目：判断字符串是否是一个 回文 字符串
 *
 * 思路：双指针
 */
public class ValidPalindrome {
    public static void main(String[] args) {
//        String s="A man, a plan, a canal: Panama";
        String s="1a2";
        boolean res=new  ValidPalindrome().isPalindrome(s);
        System.out.println(res);
    }
    public boolean isPalindrome(String s) {

        int left=0,right=s.length()-1;
        while(left<right){
            while(!isvalidchar(s.charAt(left))){
                left++;
                if(left==s.length()-1)
                    return true;
            }
            while(!isvalidchar(s.charAt(right))){
                right--;
            }
            if((s.charAt(left)&0xDF)!=(s.charAt(right)&0xDF))
                return false;
            right--;
            left++;
        }
        return true;
    }

    private boolean isvalidchar(char charAt) {
        if((charAt>='a'&&charAt<='z')||(charAt>='A'&&charAt<='Z')||(charAt>='0'&&charAt<='9'))
            return true;
        return false;
    }
}
