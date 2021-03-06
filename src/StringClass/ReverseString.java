package StringClass;

/**
 * 题目一：
 *      输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 *      例如输入字符串"I am a student. " 则输出"student. a am I"
 * 思路：
 *      一共反转两次
 *      第一次整个句子反转 第二次只反转单词 遇到‘ ’停止
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
    */

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


}
