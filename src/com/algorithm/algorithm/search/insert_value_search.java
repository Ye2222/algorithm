package com.algorithm.algorithm.search;

import java.util.Random;

import static com.algorithm.algorithm.search.binary_search.binarySearch;

public class insert_value_search {
    // 插值查找
    // 与二分查找的不同之处在于mid = left + (target - nums[left]) / (nums[right] - nums[left]) * (right - left)
    public static void insert_search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int count = 0;
        while (left <= right) {
            count++;
            int mid = left + (right - left) * (target - nums[left]) / (nums[right] - nums[left]) ;

            if(nums[mid] == target) {
                System.out.println("Yes, there is the target " +target);
                System.out.println(count);
                return;
            }
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println("No, there is no such a value");
        System.out.println(count);
    }

    /**
     * 1) 对于数据量较大， 关键字分布比较均匀的查找表来说， 采用插值查找, 速度较快.
     * 2) 关键字分布不均匀的情况下， 该方法不一定比折半查找要好
     */
    public static void main(String[] args) {
        int[] nums = {1, 8, 10, 89, 1000, 1000, 1234};
        binarySearch(nums, 8);
        insert_search(nums, 8);
    }
}
