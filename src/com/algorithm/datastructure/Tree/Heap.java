package com.algorithm.datastructure.Tree;

public class Heap {
    // 堆是完全二叉树
    // 大顶堆：每个结点的值都大于或等于其左右孩子结点的值
    // 小顶堆: 每个结点的值都小于或等于其左右孩子结点的值
    // 一般升序采用大顶堆，降序采用小顶堆

    // 堆排序
    public void heap_sort(int[] nums) {
        /**
         *  基本思想
         *  1) 将待排序序列构造成一个大顶堆
         *  2) 此时， 整个序列的最大值就是堆顶的根节点。
         *  3) 将其与末尾元素进行交换， 此时末尾就为最大值。
         *  4) 然后将剩余 n-1 个元素重新构造成一个堆， 这样会得到 n 个元素的次小值。
         *  如此反复执行， 便能得到一个有序序列了
         */

        // 步骤一
        // 构造一个初始堆，经给定无序序列构造成一个大顶堆
        // 一般升序采用大顶堆，降序采用小顶堆
        // 从最后一个非叶子结点开始，第一个非叶子结点为arr.length / 2 - 1
        // 从左至右，从下至上进行调整
        for(int i = nums.length / 2 - 1; i >= 0; i--) {
            adjust_heap(nums, i, nums.length);
        }
        // 步骤二
        // 将堆顶元素与末尾元素进行交换，使末尾元素最大
        // 然后继续调整堆，再将堆顶元素与末尾元素交换，得到第二大元素
        // 如此反复进行交换、重建、交换
        int temp;
        for(int i = nums.length - 1; i > 0; i--) {
            // 交换
            temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjust_heap(nums, 0, i);
        }
    }
    //
    // 将一个数组(二叉树), 调整成一个大顶堆
    /**
     * 功能： 完成 将 以 i 对应的非叶子结点的树调整成大顶堆
     * 举例 int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用 adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     * @param nums 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length 是在逐渐的减少
     */
    public void adjust_heap(int[] nums, int i, int length) {
        int temp = nums[i]; // 先取出当前元素的值，保存在临时变量

        // k = i * 2 + 1
        // k 是 i 结点的左子结点
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && nums[k] < nums[k+1]) {
                // 说明左子结点的值小于右子结点
                k++; // k指向右子结点
            }
            if(nums[k] > temp) {
                // 如果子结点大于父节点
                nums[i] = nums[k]; // 将较大的值赋给当前结点
                i = k; // i指向k, 继续循环比较
            } else break;
        }
        // for循环结束后，将以i为父节点的树的最大值，放到了最顶（局部）
        nums[i] = temp; // 将temp值放到调整后的位置
    }

    public static void main(String[] args) {
        int[] nums = {9, 7, 5, 80, 76};
        Heap h = new Heap();
        h.heap_sort(nums);
        for (int i:
             nums) {
            System.out.print(i + " ");
        }
    }
}
