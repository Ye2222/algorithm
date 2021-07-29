package com.algorithm.algorithm.search;

import java.util.Arrays;

import static com.algorithm.algorithm.search.binary_search.binarySearch;
import static com.algorithm.algorithm.search.insert_value_search.insert_search;

public class Fibonacci_search {
    public static int maxSize = 20;

    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1; f[1] = 1;
        for(int i = 2; i < maxSize; i++) f[i] = f[i - 1] + f[i - 2];
        return f;
    }

    // 原理相似，只是改变了中间节点(mid)的位置
    // （F[k]-1） =（F[k-1]-1） +（F[k-2]-1） +1
    // 只要顺序表的长度为 F[k]-1， 则可以将该表分成长度为 F[k-1]-1 和 F[k-2]-1 的两段
    // 中间位置为 mid=low+F(k-1)-1
    public static void FibonacciSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标
        int count = 0;
        int mid = 0;
        int[] f= fib();
        while(right > f[k] - 1) k++; // 获取到斐波那契分割数值的下标

        // 构造长度为f[k]的数组，超出nums的部分用最右边的值填充
        int[] temp = Arrays.copyOf(nums, f[k]);
        for(int i = right + 1; i < temp.length; i++) temp[i] = nums[right];

        while(left <= right) {
            count++;
            mid = left + f[k - 1] - 1;
            if(target < temp[mid]) {
                // 往左边寻找
                right = mid - 1;
                // 全部元素= 前面元素 + 后面元素
                // f[k] = f[k-1] + f[k-2]
                // 因为前面有f[k-1]个元素，所以可以继续拆分f[k-1] = f[k-2] + f[k-3]
                // 即在f[k-1]的前面继续查找
                // 下次循环 mid = f[k-1-1]-1
                k -= 1;
            } else if(target > temp[mid]) {
                left = mid + 1;
                // 全部元素= 前面元素 + 后面元素
                // f[k] = f[k-1] + f[k-2]
                // 因为后面有f[k-2] 所以可以继续拆分f[k-2] = f[k-3] + f[k-4]
                // 即在 f[k-2] 的前面进行查找 k -=2
                // 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else {
                if(mid <= right) {
                    System.out.println(mid);
                    System.out.println("次数：" + count);
                    return;
                }
                else {
                    System.out.println(right);
                    System.out.println("次数：" + count);
                    return;
                }
            }
        }
        System.out.println("There is no such a value");
        System.out.println("次数：" + count);
    }

    public static void main(String[] args) {
        int [] arr = {1,8, 10, 89, 1000, 1234};
        FibonacciSearch(arr, 8);
        binarySearch(arr, 8);
        insert_search(arr, 8);
    }
}
