package com.algorithm.algorithm.greedy_method;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class story_of_2233 {

    public static void question1(int[] v, int M){
        Arrays.sort(v);
        int m = 0, sum = 0;
        for(int i = v.length - 1; i >= 0; i--){
            sum += v[i];
            m++;
            if(m == M) break;
        }
        System.out.println(sum);
    }
    public static void question3(int[] w){
        int l = 0, r = w.length - 1;
        while(l < r){
            if(w[l] < w[r]){
                w[l+1] += w[l];
                l++;
            }
            else{
                w[r-1] += w[r];
                r--;
            }
        }
        System.out.println(l);
    }
    public static void question4(int[][] vc){
        Arrays.sort(vc, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = 0; i < o1.length; i++){
                    if(o1[i] < o2[i]) return 1;
                    else if(o1[i] > o2[i]) return -1;
                }
                return 0;
            }
        });
        int dif = 0, sumC = 0, count = 1;
        for(int i = 0; i < vc.length; i++){
            sumC += vc[i][0];
            dif += vc[i][0] - count * vc[i][1];
            if(dif < 0){
                sumC -= vc[i][0];
                dif -= vc[i][0] - count * vc[i][1];
                continue;
            }
            count++;
        }
        System.out.println(sumC);
    }
    public static void yyy(){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int max = 0;
        int[][] x = new int[n][2];
        for(int i = 0; i < n; i++){
            x[i][0] = s.nextInt();
            x[i][1] = s.nextInt();
            max = Math.max(max, x[i][0]);
            max = Math.max(max, x[i][1]);
        }
        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = o1.length - 1; i >= 0; i--) {
                    if (o1[i] < o2[i]) return -1;
                    else if (o1[i] > o2[i]) return 1;
                }
                return 0;
            }
        });

        int choose = -1, index = 0, count = 0;
        while(choose <= max){
            if(index >= n) break;
            if(x[index][0] >= choose){
                count++;
                choose = x[index][1];
            }
            index++;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        yyy();
    }
}
