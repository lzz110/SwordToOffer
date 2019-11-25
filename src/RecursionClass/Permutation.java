package RecursionClass;

import java.util.*;

/**
 * 题目：字符串全排列
 *
 * 思路：递归
 *
 *
 */

public class Permutation {
    public static void main(String[] args) {
        String str="abb";
        ArrayList<String> res=new ArrayList<>();
        res=new Permutation().Permutation(str);
        System.out.println(res);
    }

    public ArrayList<String> Permutation(String str){
        ArrayList<String> res=new ArrayList<>();
        if(str.length()>0){
            PermutationHelper(str.toCharArray(),0,res);
        }
        Collections.sort(res);
        return res;
    }

    private void PermutationHelper(char[] cs, int i, ArrayList<String> res) {
        if(i==cs.length-1){
           String val=String.valueOf(cs);
           if(!res.contains(val)){
               res.add(val);
           }
        }else{
            for(int j=i;j<cs.length;j++){
                swap(cs,i,j);
                PermutationHelper(cs, i+1, res);
                swap(cs,j,i);
            }
        }
    }
    private void swap(char[] cs,int i,int j){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
    /*
    public ArrayList<String> RecursionClass.Permutation(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            PermutationHelper(str.toCharArray(),0,list);
            Collections.sort(list);   //按照字典序排序
        }
        return list;
    }
    public static void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {   // 递归结束条件：索引已经指向str最后一个元素时  当i==2的时候 添加结果
            String val = String.valueOf(cs);
            if (!list.contains(val))    //判断结果中是否存在 没有则加入
                list.add(val);
        } else {
            // 第一次循环i与begin相等，相当于第一个位置自身交换，关键在于之后的循环，
            // 之后i != begin，则会交换两个不同位置上的字符，直到begin==str.size()-1，进行输出；
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);     //交换之后固定j 进入循环
                PermutationHelper(cs, i+1, list);
                swap(cs, j, i);
            }
        }
    }*/

}
