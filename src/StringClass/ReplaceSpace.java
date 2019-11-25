package StringClass;

/**
 * 题目：
 *      请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *      当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路：
 *      在原来的字符串上替换： 双指针 从后往前 替换，减少数组中字符移动次数
 *      在新的字符串上替换：   从前向后 查找 使用 StringBuilder 的append
 * 注意：  StringBuilder.setChatAt()
 *        StringBuilder.setLength()
 *
 *
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer oristr=new StringBuffer("We Are Happy");
        String res=new ReplaceSpace().replaceSpace(oristr);
        System.out.println(res);
    }

    /*
    //在源字符串上替换
    public static String replaceSpace(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexold = str.length()-1;                  //indexold为为替换前的str下标
        int newlength = str.length() + spacenum*2;      //计算空格转换成%20之后的str长度
        int indexnew = newlength-1;                     //indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);                       //使str的长度扩大到转换成%20之后的长度,防止下标越界
        for(;indexold>=0 && indexold<newlength;--indexold){
            if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }

    //新字符串上替换
    public String replaceSpace(StringBuffer str) {
        if(str==null||str.length()==0)
            return "";
        int oriindex, newindex,spacenumber=0;
        //计算空格数
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)==' ')
                spacenumber++;
        }
        int newlength=str.length()+spacenumber*2;
        StringBuilder newstr=new StringBuilder();
        newstr.setLength(newlength);
        oriindex=str.length()-1;
        newindex=newlength-1;

        for (;oriindex>=0&&newindex>=0; oriindex--) {
            if(str.charAt(oriindex)==' '){
                newstr.setCharAt(newindex--,'0');
                newstr.setCharAt(newindex--,'2');
                newstr.setCharAt(newindex--,'%');
            }else{
                newstr.setCharAt(newindex--,str.charAt(oriindex));
            }
        }

        return newstr.toString();
    }
    */
    //使用StringBuffer
    public String replaceSpace(StringBuffer str) {
        if(str==null||str.length()==0)
            return "";
        StringBuffer newStr = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                newStr.append("%20");
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();

    }
}


