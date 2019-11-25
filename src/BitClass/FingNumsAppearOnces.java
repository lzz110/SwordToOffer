package BitClass;

/**
 *  题目：
 *      一个整型数组里除了两个数字之外，其他的数字都出现了两次。找出这两个只出现一次的数字。
 *  思路：
 *      方法一：使用 hashmap 遍历寻找 value==1 的 key
 *      方法二：使用位运算 依次异或 结果为 A 和 B的不同的位 取第一个1所在的位 把原数组分为两组
 *              相同的数肯定在一个组 不同的数在另一组 依次异或 剩余的两个结果就是这两个只出现一次的数字
 */
public class FingNumsAppearOnces {
    public static void main(String[] args) {
        int[] array={1,1,1,1,4,6};
        int[] num1=new int[1];
        int[] num2=new int[1];
        new FingNumsAppearOnces().FindNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
        int temp=8;
        //System.out.println(findFirst1(temp));
    }
    /*public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> hashmap=new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(!hashmap.containsKey(array[i])){
                hashmap.put(array[i],1);
            }else{
                int value=hashmap.get(array[i]);
                hashmap.put(array[i],++value);
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = hashmap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            if(next.getValue()==1){
                res.add(key);
            }
        }
        if(res.size()==2){
            num1[0]=res.get(0);
            num2[0]=res.get(1);
        }
    }*/
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }



















}
