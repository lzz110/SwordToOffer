package SortClass;

import java.util.Arrays;

/**
 * @author lzz
 * @version 1.0
 * @description: TODO
 * @date 2020/9/15 20:22
 */
public class SortClass {
    public static void main(String[] args) {
        int[] arr={4,7,1,2,8,3};
//        new SortClass().BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
//        int[] newarr= Arrays.copyOfRange(arr,0,2);
//        System.out.println(Arrays.toString(newarr));
//          int[] resarr= new SortClass().mergeSort(arr);
//        new SortClass().MySelect(arr);
        new SortClass().heapSort(arr);
//
        System.out.println(Arrays.toString(arr));
    }

    /**
     *  冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤 1~3，直到排序完成
     *
     *  此处对代码做了一个小优化，加入了 is_sorted Flag，目的是将算法的最佳时间复杂度优化为 O(n)，即当原输入序列就是排序好的情况下，该算法的时间复杂度就是 O(n)。
     *     # 算法分析稳定性：
     *     稳定时间复杂度：最佳：O(n) ，最差：O(n2)， 平均：O(n2)
     *     空间复杂度：O(1)排序方式：In-place
     *
     */


    public void MyBubbleSort(int[] arr){
        boolean isSorted = true;
        int len= arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr, j,j+1);
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }

    }


    /**
     * 选择排序
     *
     * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     * 重复第 2 步，直到所有元素均排序完毕
     *
     * #算法分析
     * 稳定性：不稳定
     * 时间复杂度：最佳：O(n2) ，最差：O(n2)， 平均：O(n2)
     * 空间复杂度：O(1)
     * 排序方式：In-place
     *
     */


    public void MySelectSort(int[] arr){
        int len= arr.length;
        for (int i = 0; i < len; i++) {
            int minIndex= i;
            for (int j = i+1; j < len; j++) {
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
        }
    }


    /**
     * 插入排序 : 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     *
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置；将新元素插入到该位置后；
     * 重复步骤 2~5。
     *
     *  * 稳定性：稳定
     *      * 时间复杂度：最佳：O(n) ，最差：O(n2)， 平均：O(n2)
     *      * 空间复杂度：O(1)
     *      * 排序方式：In-place
     */

    public void MyInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int preindex= i-1;
            int curr = arr[i];
            while(preindex >=0 && curr < arr[preindex]){
                arr[preindex + 1] = arr[preindex];
                preindex--;
            }
            arr[preindex+1]= curr;
        }
    }

    /**
     *
     * 快速排序是一种基于分而治之的排序算法，其中：
     * 1、通过从数组中选择一个中心元素将数组划分成两个子数组，在划分数组时，将比中心元素小的元素放在左子数组，将比中心元素大的元素放在右子数组。
     * 2、左子数组和右子数组也使用相同的方法进行划分，这个过程一直持续到每个子数组都包含一个元素为止。
     * 3、最后，将元素组合在一起以形成排序的数组。
     *
     * 其中分治算法过程：
     *  1. 选择数组的最后一个元素作为中心元素。
     *  2. 指针固定在中心元素上，将中心元素与从第一个索引开始的元素进行比较。
     *  3. 如果该元素大于中心元素，则为该元素设置第二指针
     *  4. 现在将中心元素与其他元素进行比较，如果到达的元素小于或等于中心元素时，则将较小的元素和上次找到的较大元素交换位置。
     *  5. 该过程一直进行到到达倒数第二个元素为止
     *  6. 最后将中心元素与第二个指针指向的元素交换位置。
     * 注意：
     *  1. 递归函数中首先写判断条件： 当 low < high 时进行递归
     *  2. 递归函数的变量是中间节点的两侧，不包含中间节点
     *
     */


    public int partition(int[] array, int low, int high) {
        int pivot= array[high];
        int secondpointer = low;
        for (int i = low; i < high; i++) {
            if(array[i] <= pivot){
                swap(array,i,secondpointer);
                secondpointer++;
            }
        }
        swap(array,secondpointer,high);
        System.out.println(Arrays.toString(array));
        return secondpointer;
    }

    public  void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 获取划分子数组的位置
            int position = partition(array, low, high);
            // 左子数组递归调用
            quickSort(array, low, position -1);
            // 右子数组递归调用
            quickSort(array, position + 1, high);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    /**
     * 归并排序
     * 算法步骤：
     * 归并排序算法是一个递归过程，边界条件为当输入序列仅有一个元素时，直接返回，
     * 具体过程如下：如果输入内只有一个元素，则直接返回，否则将长度为 n 的输入序列分成两个长度为 n/2 的子序列；
     * 分别对这两个子序列进行归并排序，使子序列变为有序状态；
     * 设定两个指针，分别指向两个已经排序子序列的起始位置；比较两个指针所指向的元素，选择相对小的元素放入到合并空间（用于存放排序结果），并移动指针到下一位置；
     * 重复步骤 3 ~4 直到某一指针达到序列尾；将另一序列剩下的所有元素直接复制到合并序列尾。
     *
     * @param arr
     * @return arr
     */
    public  int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int middle = arr.length / 2;
        int[] arr_1 = Arrays.copyOfRange(arr, 0, middle);
        int[] arr_2 = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(arr_1), mergeSort(arr_2));
    }

    /**
     * Merge two sorted arrays
     *
     *
     *
     * @param arr_1
     * @param arr_2
     * @return sorted_arr
     */
    public  int[] merge(int[] arr_1, int[] arr_2) {
        int[] sorted_arr = new int[arr_1.length + arr_2.length];
        int idx = 0, idx_1 = 0, idx_2 = 0;
        while (idx_1 < arr_1.length && idx_2 < arr_2.length) {
            if (arr_1[idx_1] < arr_2[idx_2]) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1 ++;
            } else {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2 ++;
            }
            idx++;
        }
        if (idx_1 < arr_1.length) {
            while (idx_1 < arr_1.length) {
                sorted_arr[idx] = arr_1[idx_1];
                idx_1++;
                idx++;
            }
        } else {
            while (idx_2 < arr_2.length) {
                sorted_arr[idx] = arr_2[idx_2];
                idx_2++;
                idx++;
            }
        }
        return sorted_arr;
    }

    /**
     * 堆排序
     *   首先将待排序的数组构造成一个大根堆（升序用大根堆，降序用小根堆），从最后一个非叶子节点开始向上调整，最后一个非叶子节点的索引是 arr.length/2 -1
     *   然后将堆顶元素（最大值）与末尾元素交换，并将剩余的n-1个元素重新调整为大根堆，
     *   重复这个过程直到只剩一个元素为止。
     *   调整大顶堆的函数中：
     *   左孩子的索引 2 * i + 1
     *   右孩子的索引 2 * i + 2
     *   如果最大节点不是当前节点，交换它们的值，并递归地调整被交换的子树，其中调整的节点为 largest， adjustHeap(arr, largest, size);
     * @param arr
     */

    public void heapSort(int[] arr) {
        // 构建一个大根堆，从最后一个非叶子节点开始向上调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 交换堆顶元素和末尾元素，然后重新调整堆，直到堆中只剩一个元素
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 将最大元素放到数组末尾
            adjustHeap(arr, 0, i); // 将剩余元素重新调整为大根堆
        }
    }

    // 调整堆的方法，参数是一个整型数组，一个节点索引和一个堆的大小
    public  void adjustHeap(int[] arr, int i, int size) {
        int left = 2 * i + 1; // 左孩子的索引
        int right = 2 * i + 2; // 右孩子的索引
        int largest = i; // 假设当前节点是最大的
        if (left < size && arr[left] > arr[largest]) { // 如果左孩子存在且比当前节点大，更新最大节点的索引
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) { // 如果右孩子存在且比当前节点大，更新最大节点的索引
            largest = right;
        }
        if (largest != i) { // 如果最大节点不是当前节点，交换它们的值，并递归地调整被交换的子树
            swap(arr, i, largest);
            adjustHeap(arr, largest, size);
        }

        System.out.println(Arrays.toString(arr));
    }




}
