package leetcode;

public class ZeroArrayTransformationI {
    public static void main(String[] args) {
        int[] a = {4,3,2,1};
        int[][] b = {{0,1},{0,2},{0,3}};
        System.out.println(isZeroArray(a, b));
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int[] diff = new int[nums.length + 1];

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            diff[left]++;
            if (right + 1 < nums.length) {
                diff[right + 1]--;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            diff[i] += diff[i-1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > diff[i]) {
                return false;
            }
        }

        return true;
    }
}

