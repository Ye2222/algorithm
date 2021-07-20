package com.algorithm.algorithm.sort;

public class merge {
    public static void merge_sort(int[] arr, int left, int right, int[] temp){
        if(left < right){
            int mid = left + (right - left) / 2;
            merge_sort(arr, left, mid, temp);
            merge_sort(arr, mid + 1, right, temp);
            Merge(arr, left, mid, right, temp);
        }
    }
    public static void Merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left, j = mid + 1, t = 0;

        // 把左右两边的数据填充到temp数组，直到有一边填充完毕
        // 将较小的数据填充进去
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }
            else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // 把有剩余的一组数据填充进temp
        while(i <= mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while(j <= right){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // 拷贝
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 5, 2, 8, 7, 8};
        int[] temp = new int[arr.length];
        merge_sort(arr, 0, arr.length - 1, temp);
        for (int i : arr) System.out.print(i + " ");
    }
}
