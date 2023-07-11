package BackTrackClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xdr630
 * @version 1.0
 * @date 2023/7/11 11:17
 *
 *
 * leetcode 77. 组合
 *
 * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
 *     用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
 *     可以剪枝的地方就在递归中每一层的for循环所选择的起始位置。
 *
 *     如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
 *     在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
 *
 *  注意： 组合和排列的区别：
 *
 *          组合和排列的区别 只有for 循环中 变量i 的赋值不同，
 *          组合 是不能 选取之前的元素，所以有 startInd 概念
 *          排列 是可以 选取之前的元素，所以从 i=0 开始，遍历使用过的数组 used[]
 *
 *        去重：
 *
 */
public class combine {


    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    /**
     *
     */
    private void combineHelper(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        //for (int i = startIndex; i <= n; i++){
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){      //剪枝优化
            path.add(i);
            combineHelper(n, k, i + 1);
            path.removeLast();
        }
    }




}
