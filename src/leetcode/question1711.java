package leetcode;

import java.util.HashMap;
import java.util.Map;

public class question1711 {
    // 暴力法
    public static void question(int[] d){
        int n = d.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int sum = d[i] + d[j];
                while((sum / 2) % 2 == 0){
                    sum = sum / 2;
                }
                if(sum == 2) count = (count+1) % ((int)Math.pow(10, 9)+7);
            }
        }
        System.out.println(count);
    }
    // 哈希表
    public static void question1(int[] d){
        int MOD = 1000000007;
        int maxval = 0;
        for(int val : d){
            maxval = Math.max(maxval, val);
        }
        int maxSum = maxval * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap();
        int n = d.length;
        for(int i = 0; i < n; i++){
            int val = d[i];
            for(int sum = 1; sum <= maxSum; sum <<= 1){
                int count = map.getOrDefault(sum- val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        System.out.println(pairs);
    }
    public static void main(String[] args) {
        int[] d = {149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        question1(d);
    }
}
