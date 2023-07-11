package BackTrackClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/11 12:43
 *
 *
 *
 */
public class Permute {
   /*
   List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return result;
        }
        used = new boolean[nums.length];
        permuteHelper(nums);
        return result;
    }

    private void permuteHelper(int[] nums){
        if (path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            permuteHelper(nums);
            path.removeLast();
            used[i] = false;
        }
    }
    */


    List<String> list = new ArrayList<>();
    LinkedList<Character> path = new LinkedList<>();
    boolean[] used;
    public String[] permutation(String s) {
        //把s变成数组
        char[] vals =s.toCharArray();
        Arrays.sort(vals);
        used = new boolean[vals.length];    //一定要先进行赋值，否则回溯中会遇到 used[i]= null 错误
        backtracking(vals);
        //对list进行处理,变成String数组
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void backtracking(char[] vals) {
        //终止
        if (path.size() == vals.length) {
            //把path放入StringBuidler再变成String,再放入list
            StringBuilder sb = new StringBuilder();
            for (Character c : path) {
                sb.append(c);
            }
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < vals.length; i++) {
            if (i > 0 && vals[i] == vals[i - 1] && used[i - 1]==false ) {   //剪枝
                continue;
            }
            if(used[i]==true){  //遇到取过的数直接跳过
                continue;
            }
            path.add(vals[i]);
            used[i] = true;
            backtracking(vals);
            used[i] = false;
            path.removeLast();
        }
    }

}
