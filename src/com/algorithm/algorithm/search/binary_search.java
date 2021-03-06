package com.algorithm.algorithm.search;

public class binary_search {
    public static void binarySearch(int[] nums, int target){
        int n = nums.length;
        int left = 0, right = n;
        int count = 0;
        while(left < right) {
            count++;
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                System.out.println("Yes, there is the target " +target);
                System.out.println(count);
                return;
            }
            else if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        System.out.println("No, there is no such a value...");
        System.out.println(count);
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 9, 29};
        binarySearch(nums, 10);
    }
}
