package leetcode;

public class MedianTwoSortedArr {
    public static void main(String[] args) {
        int [] nums1 = new int[]{1,2};
        int [] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum += nums1[i];
        }
        double median1 = sum / nums1.length;

        sum = 0;
        for (int i = 0; i < nums2.length; i++) {
            sum += nums2[i];
        }
        double median2 = sum / nums2.length;

        return (median1 + median2) / 2;
    }
}
