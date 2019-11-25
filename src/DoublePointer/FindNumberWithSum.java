package DoublePointer;

import java.util.ArrayList;
import java.util.Iterator;

public class FindNumberWithSum {
    public static void main(String[] args) {
        int[] array={1,2,3,8,15,16};
        int sum=17;
        ArrayList<Integer> res=new FindNumberWithSum().FindNumbersWithSum(array,sum);
        Iterator it=res.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res=new ArrayList<>();

        if(array==null||array.length==0)
            return res;
        int left=0,right=array.length-1;
        while(left<right){
            if(array[left]+array[right]==sum){
                res.add(array[left]);
                res.add(array[right]);
                break;
            }else if(array[left]+array[right]>sum){
                right--;
            }else{
                left++;
            }
        }
        return  res;
    }
















    /*public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result=new ArrayList<>();
        int left=0,right=array.length-1;
        while(left<right){
            int res=array[left]+array[right];
            if(res<sum)
                left++;
            else if(res>sum)
                right--;
            else{
                result.add(array[left]);
                result.add(array[right]);
                break;
            }
        }
        return result;
    }*/
}
