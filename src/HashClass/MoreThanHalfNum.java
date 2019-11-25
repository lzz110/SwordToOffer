package HashClass;

/**
 *  题目：
 *      数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *      例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 *      由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *  思路：
 *      方法一：使用 hash表 创建 hash表 遍历 hash表
 *      方法二：使用 count    if(temp==array[i]) count++ else count-- 再判断 一遍 temp 的个数
 *  注意:
 *      遍历 hash 表的方法
 */
public class MoreThanHalfNum {
    public static void main(String[] args) {
//        Integer[] arrays={1,2,3,2,4,1,5,2,3};
        int[] arrays={1,2,3,2,4,1,5,2,3};
//        int[] arrays={1,2,3,2,2,2,5,4,2};

//        Arrays.sort(arrays,Collections.reverseOrder());
//        for (int i = 0; i <arrays.length ; i++) {
//            System.out.print(arrays[i]+" ");
//        }
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(arrays));
    }

    /*
    //hash
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        //创建hash表
        HashMap<Integer,Integer> hashMap=new HashMap();
        for(int i=0;i<array.length;i++){
            if(!hashMap.containsKey(array[i])){
                hashMap.put(array[i],1);
            }else{
                int number=hashMap.get(array[i]);
                hashMap.put(array[i],++number);
            }
        }
        //遍历hash表
        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            Integer value = next.getValue();
            if(value>array.length/2){
                return key;
            }
        }
        return 0;
    }
    */

    //使用count
    public int MoreThanHalfNum_Solution(int [] array) {
        int count=0,temp=0;
        for (int i = 0; i < array.length; i++) {
            if(count==0){
                temp=array[i];
                count++;
            }else if(temp==array[i]){
                count++;
            }else{
                count--;
            }
        }
        count=0;
        for(int i=0;i<array.length;i++){
            if(temp==array[i]){
                count++;
            }
        }
        return count>array.length/2?temp:0;
    }

}

