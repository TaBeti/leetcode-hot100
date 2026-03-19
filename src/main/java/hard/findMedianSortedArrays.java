package hard;

import java.util.Scanner;

/**
 * 寻找两个正序数组的中位数
 */
public class findMedianSortedArrays {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //处理长度短的数组
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m - 1;
        //只需要对 nums1进行二分
        while (left <= right) {
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i - 2;
            if (nums1[i] <= nums2[j + 1]) left = i + 1;
            else right = i - 1;
        }
        int i = right, j = (m + n + 1) / 2 - i - 2;
        int ai = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
        int bj = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
        int ai1 = i + 1 < m ? nums1[i + 1] : Integer.MAX_VALUE;
        int bj1 = j + 1 < n ? nums2[j + 1] : Integer.MAX_VALUE;
        int max1 = Math.max(ai, bj);
        int min2 = Math.min(ai1, bj1);
        return (m + n) % 2 > 0 ? max1 : (max1 + min2) / 2.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split1 = sc.nextLine().split(" ");
        int[] nums1 = new int[split1.length];
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = Integer.parseInt(split1[i]);
        }
        String[] split2 = sc.nextLine().split(" ");
        int[] nums2 = new int[split2.length];
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = Integer.parseInt(split2[i]);
        }
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
