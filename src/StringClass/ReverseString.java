package StringClass;

/**
 * 题目一：
 *      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *      例如输入字符串"I am a student. " 则输出"student. a am I"
 * 思路：
 *      方法一： 一共反转两次
 *          第一次整个句子反转 第二次只反转单词 遇到‘ ’停止
 *
 *      方法二： 从后往前，注意单词中间的多余空格删除
 *
 *
 *
 * 题目二：字符序列 S=”abcXYZdef”,要求输出循环左移3位后的结果，即 “XYZdefabc”。
 *
 * 思路：
 *      方法一：字符串拼接 使用String.substring(start,end) 注意 substring() 从 start 到 end-1
 *      方法二：三次反转  第一次反转前3个 第二次反转4 到str.length 第三次全部反转 使用 str.toCharArray()
 *
 * 注意：将charArray 还原成 String  使用  new String(charArray)
 */




public class ReverseString {

    public static void main(String[] args) {
//        System.out.println(StringClass.ReverseString("abcd".toCharArray(),0,3));
//        System.out.println("abcdefg".length());
//        System.out.println(new ReverseString().LeftRotateString("abcdefg",2));
//        System.out.println(new StringClass.ReverseString().LeftRotateString("",6));     //返回""
//        System.out.println("".length());
        System.out.println(new ReverseString().ReverseSentence("I am a student."));

    }

    /*
    题目一：
    public String ReverseSentence(String str) {

        if(str==null||str.length()==0)
            return "";
        int len=str.length();
        char[] StrToCharArray=str.toCharArray();
        StringClass.ReverseString(StrToCharArray,0,len-1);
        int left=0,right=0;
        while(left<str.length()){
            while(right<str.length()&&StrToCharArray[right]!=' '){    //因为循环中有right++ 所以外部需要判断right
                right++;
            }
            StringClass.ReverseString(StrToCharArray,left,right-1) ;    //当前的right指向的是' ',反转需要-1
            right++;
            left=right;
        }
        return new String(StrToCharArray);      //将charArray 还原成 String
    }

    /**
     * 不使用Java内置方法实现
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }


    public String reverseWords2(String s) {
        s = s.trim(); // 删除首尾空格
        int slow = s.length() - 1, fast = slow;
        StringBuilder res = new StringBuilder();
        while(fast >= 0) {
            while(fast >= 0 && s.charAt(fast) != ' ') fast--; // 搜索首个空格
            res.append(s.substring(fast + 1, slow + 1) + " "); // 添加单词
            while(fast >= 0 && s.charAt(fast) == ' ') fast--; // 跳过单词间空格
            slow = fast; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }


    private StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    /**
     *
     * 双指针 反转每个单词
     * @param sb
     */
    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }


    //题目二:
    //字符串截取拼接思想
    /*public String LeftRotateString(String str,int n) {
        if(str==null)
            return null;
        if(str.length()==0)
            return "";
        n=n%str.length();
        StringBuffer sb1=new StringBuffer(str.substring(n,str.length()));
        StringBuffer sb2=new StringBuffer(str.substring(0,n));
        sb1.append(sb2);
        return sb1.toString();
    }*/



    //反转3次
    /*public String LeftRotateString(String str,int n) {
        if(str==null)
            return null;
        if(str.length()==0)
            return "";
        n=n%str.length();
        char[] strtochararray=str.toCharArray();
        ReverseString(strtochararray,0,n-1);
        ReverseString(strtochararray,n,str.length()-1);
        ReverseString(strtochararray,0,str.length()-1);
        return new String(strtochararray);

    }*/
    //双指针反转字符串 注意交换之后 需要指针继续移动
    private void ReverseString(char[] str, int start, int end) {
        while(start<end){
            char temp=str[start];
            str[start]=str[end];
            str[end]=temp;
            start++;
            end--;
        }
    }

    public String ReverseSentence(String str) {
        if(str==null)
            return null;
        if(str.length()==0)
            return "";
        char[] strtochar=str.toCharArray();
        ReverseString(strtochar,0,str.length()-1);
        int left=0,right=0;
        while(left<str.length()){
            while(right<str.length()&&strtochar[right]!=' '){
                right++;
            }
            ReverseString(strtochar,left,right-1);
            right++;
            left=right;
        }
        return new String(strtochar);
    }

    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left<right){
            char temp = s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }


}
