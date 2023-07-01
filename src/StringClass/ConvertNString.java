package StringClass;
import java.util.*;
/**
 * Created by 79331 on 2023/6/21 11:29
 *
 * leetcode 第6题
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *

 */


public class ConvertNString {

    public String convert(String s, int numRows) {
        //特判
        if(numRows <2) return s;
        List<StringBuilder> temp= new ArrayList<>(numRows);
        //一定要初始化temp list， 否则到temp.get(i).append(ch); 的时候会出现数组越界异常
        for(int i=0;i<numRows;i++){
            temp.add(new StringBuilder());
        }
        int i=0,flag = -1;

        for(Character ch: s.toCharArray()){
            temp.get(i).append(ch);
            if(i==0|| i==numRows -1) flag = -flag;
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder string:temp) res.append(string);
        return res.toString();

    }
}

