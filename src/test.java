import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class test {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int tot = nums1.length + nums2.length;
        if (tot % 2 == 0) {
            int left = find(nums1, 0, nums2, 0, tot / 2); // 2
            int right = find(nums1, 0, nums2, 0, tot / 2 + 1); // 3
            System.out.println(left + " " + right);
            return (left + right) / 2.0;
        } else {
            return find(nums1, 0, nums2, 0, tot / 2 + 1);
        }
    }
    static int find(int[] n1, int i, int[] n2, int j, int k) {
        System.out.println("k is "+k + " i is " + i + " j is " + j);
        if (n1.length - i > n2.length - j) return find(n2, j, n1, i, k);
        if (i >= n1.length) return n2[j + k - 1];
        if (k == 1) {
            return Math.min(n1[i], n2[j]);
        } else {
            int si = Math.min(i + (k / 2), n1.length), sj = j + k - (k / 2);
            if (n1[si - 1] > n2[sj - 1]) {
                return find(n1, i, n2, sj, k - (sj - j));
            } else {
                return find(n1, si, n2, j, k - (si - i));
            }
        }
    }

    public static void main(String[] args){
        int[] num1 = {1, 3,6, 6,7, 8,34};
        int[] num2 = {2 ,4};
        System.out.println(findMedianSortedArrays(num1, num2));
    }
}
