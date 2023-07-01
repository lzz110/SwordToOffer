package NumberClass;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/6/21 20:05
 *
 * 罗马数字包含以下七种字符 I， V， X， L，C，D 和 M
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 给你一个整数，将其转为罗马数字。  输入: num = 58   输出: "LVIII"   解释: L = 50, V = 5, III = 3
 *
 * 思路：
 * 贪心算法，设置一个对应列表，从大往小用罗马数字
 *     int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
 *     String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
 *
 *
 */
public class IntToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index= 0;
        StringBuilder sb=new StringBuilder();
        while(index< values.length){
            while(num >=values[index]){
                sb.append(symbols[index]);
                num=num-values[index];
            }
            index++;
        }
        return sb.toString();
    }

    /**
     * @author xdr630
     * @version 1.0
     * @date 2023/6/21 20:05
     *
     * 罗马数字包含以下七种字符 I， V， X， L，C，D 和 M
     *
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 给你一个罗马数字，将其转为整数。  输入: num = LVIII   输出: "58"   解释: L = 50, V = 5, III = 3
     *
     * 思路：
     * 贪心算法，设置一个对应列表，从大往小用罗马数字
     *     int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
     *     String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
     *
     *
     */

    public int romanToInt(String s) {
        //特判
        if(s==null|| s.length()<1) return 0;
        char[] charArray = s.toCharArray();
        int sum =0,len=s.length(), pre=getValue(charArray[0]);
        for (int cur = 1; cur < len ; cur++) {
            int temp=getValue(charArray[cur]);
            if(pre>=temp){
                sum+=pre;
            }else{
                sum-=pre;
            }
            pre=temp;
        }
        sum+=pre;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

}
