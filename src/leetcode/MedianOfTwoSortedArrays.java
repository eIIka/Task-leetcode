package leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] result = Arrays.copyOf(nums1, length);

        int j = 0;
        for (int i = nums1.length; i < length; i++, j++){
            result[i] = nums2[j];
        }

        result = Arrays.stream(result).sorted().toArray();

        if (length % 2 == 0){
            int left = result[(int) ((length / 2) - 0.5)];
            int right = result[(int) ((length / 2) + 0.5)];
            return (left + right) / 2.0;
        }

        return result[length / 2];
    }
}
