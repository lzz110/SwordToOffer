package HashAndSetClass;

/**
 * 题目：
 *      在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 *      并返回它的位置,如果没有则返回 -1（需要区分大小写）
 *
 * 思路：
 *      自己创建一个 hash表，节省空间
 * 注意：
 *      0：48  A:65 a:97
 */
public class FirstNotRepeatChar {
    public static void main(String[] args) {
        String str="z";
        System.out.println(str.charAt(0)-'0');
//        System.out.println(new HashClass.FirstNotRepeatChar().FirstNotRepeatingChar(str));
    }

    //自己创建一个hash表
    public int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0)
            return -1;
        int res=-1;

        int[] hash=new int[256];
        for(int i=0;i<str.length();i++){
            hash[str.charAt(i)-'0']++;
        }
        for(int i=0;i<str.length();i++){
            if(hash[str.charAt(i)-'0']==1)
                return i;
        }
        return res;
    }


    /*public int FirstNotRepeatingChar(String str) {
        if(str==""){
            return -1;
        }
        char[] charArray1 = str.toCharArray();
        char[] charArray2 = new char[255];
        int result=-1;
        for(int i=0;i<charArray1.length;i++){
            charArray2[charArray1[i]]+=1;
        }
        for(int i=0;i<charArray1.length;i++){
            if(charArray2[charArray1[i]]==1){
                result =i;
                break;
            }
        }
        return result;
    }*/
}
