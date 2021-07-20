package com.algorithm.algorithm.sort;

public class radix {
    public static void radix_sort(int[] nums){
        // 找到数组中最大的数的位数
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max) max = nums[i];
        }
        int maxLength = (max+"").length();

        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        // 防止数据溢出，每个一维数组，大小定为nums.length
        // 基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][nums.length];

        // 定义一个一维数组，记录每个桶中实际存放的数据个数
        int[] bucketElementCounts = new int[10];

        for(int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 针对每个元素的对应位进行排序处理
            // 第一次是个位，第二次是十位，第三次是百位，以此类推
            for(int j = 0; j < nums.length; j++){
                // 取出每个元素的对应位的值
                int digitOfElement = nums[j] / n % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = nums[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;
            for(int k = 0; k < bucketElementCounts.length;k++){
                if(bucketElementCounts[k] != 0) {
                    for(int l = 0; l < bucketElementCounts[k]; l++){
                        nums[index++] = bucket[k][l];
                    }
                }
                // 第i+1轮处理后，需要将每个bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 2, 8, 4, 6, 2, 1};
        radix_sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
