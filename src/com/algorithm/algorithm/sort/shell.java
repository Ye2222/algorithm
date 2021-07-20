package com.algorithm.algorithm.sort;

public class shell {
    // 交换法的希尔排序
    public static void shellSort(int[] arr){
        int temp = 0, count = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            // 插入排序,从第gap个元素开始
            for (int i = gap; i < arr.length; i++){
                for(int j = i - gap; j >= 0; j -= gap){
                    if(arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }
    // 移位法的希尔排序
    public static void shellSort2(int[] arr){
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                // 插入排序,从第gap个元素开始
                int j = i;
                int temp = arr[i];
                if(arr[j] < arr[j-gap]){
                    while(j - gap >= 0 && temp < arr[j-gap]){
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] arr= {2, 5, 1, 66, 23, 13};
        shellSort2(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+ " ");
    }
}
