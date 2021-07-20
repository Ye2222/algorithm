package com.algorithm.algorithm.sort;

public class quick {
    public static void solution(int[] arr, int left, int right){
        int n = left + (right - left) / 2;
        if(n < 0 || n > arr.length) return;
        int pivot = arr[n];
        int l = left, r =right;
        while(l < r){
            while(arr[l] < pivot) l+=1;
            while(arr[r] > pivot) r-=1;
            if(l >= r) break;

            // 前移
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 这里为啥要写这一步呢？
            // 原因是，如果刚好此时左边和右边的数都是pivot，那么就等于没有交换，
            // 下一次循环还是会因为这样而无法进行交换，死循环
            // 交换完，发现arr[l]==pivot，前移
            if(arr[l] == pivot) r-=1;
            // 交换完，发现arr[r]==pivot,后移
            if(arr[r] == pivot) l+=1;
        }
        if(l == r){
            l+=1;
            r-=1;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println();
        // 左递归
        if(left < r) solution(arr, left, r);
        // 右递归
        if(right > l) solution(arr, l, right);
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 2, 1, 8};
        solution(arr, 0, 5);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] +" ");
        }
    }
}
