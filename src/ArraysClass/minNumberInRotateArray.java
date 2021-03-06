package ArraysClass;

/**
 * 题目：
 *      把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *      输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *      例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *      NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路：
 *      二分思想
 *      if(mid<right) 最小值肯定在 mid的左边
 *           right=mid;
 *      else if(mid>right)  最小值肯定在 mid的右边
 *          left=mid+1;
 *      else(mid==right)      最小值左右都有可能，将right--
 *          right--;
 *
 * 注意：
 *      判断空指针和数组长度时，要先判断空指针，否则会出现 NullPointerException
 *      if(array==null||array.length==0)
 */

public class minNumberInRotateArray {
    public static void main(String[] args) {
//        int[] arr={1,1,1,2,0};
        int[] arr={3,4,5,1,2};
//        int[] arr={5,1,2,3,4};
//        int arr[] = { 3, 4, 5, 1, 1, 2 };
//        int arr[] = { 3, 4, 5, 1, 2, 2 };
//        int arr[] = { 1, 0, 1, 1, 1 };
//        int arr[] = { 2 };
//        int arr[]=null;
        int res=new minNumberInRotateArray().minNumberInRotateArray(arr);
        System.out.println(res);
    }

    public  int minNumberInRotateArray(int [] array) {
        int res=0;
        if(array==null||array.length==0)
            return res;
        int len=array.length;
        int left=0,right=len-1,mid=0;
        while(left<right){
            mid=left+(right-left)/2;
            if(array[mid]>array[right]){
                left=mid+1;
            }else if(array[mid]<array[right]){
                right=mid;
            }else{
                   right--;
            }
        }
        return array[left];
    }
}
