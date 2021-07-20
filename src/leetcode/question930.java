package leetcode;

import java.util.HashMap;
import java.util.Map;

public class question930 {
    // 前缀和+哈希表
    public static void solution1(int[] nums, int goal){
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        for(int i : nums){
            map.put(sum, map.getOrDefault(sum, 0) + 1); // 记录前缀和
            sum += i; // 更新前缀和
            count += map.getOrDefault(sum - goal, 0); // 查找sum-goal的前缀和
        }
        System.out.println(count);
    }
    // 双指针
    public static void solution2(int[] nums, int goal){
        int n = nums.length;
        int count = 0;
        for(int r = 0, l1 = 0, l2 = 0, s1 = 0, s2 = 0; r < n; r++){
            s1 += nums[r];
            s2 += nums[r];
            while (l1 <= r && s1 > goal) s1 -= nums[l1++];
            while (l2 <= r && s2 >= goal) s2 -= nums[l2++];
            count += l2 - l1;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int[] m = {1, 0, 1, 0, 1};
        solution2(m, 2);
    }
}
