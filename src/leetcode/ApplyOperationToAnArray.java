package leetcode;

import java.util.Arrays;

public class ApplyOperationToAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,1,1,0};

        System.out.println(Arrays.toString(applyOperations(nums)));
    }

    private static int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int k = 0;
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }

            if (nums[i] != 0) {
                res[k++] = nums[i];
            }
        }

        if (nums[i] != 0) {
            res[k] = nums[i];
        }

        return res;

//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i+1]) {
//                nums[i] *= 2;
//                nums[i+1] = 0;
//            }
//        }
//
//        int i = 0;
//        for (int num : nums) {
//            if (num != 0) {
//                nums[i++] = num;
//            }
//        }
//
//        while (i < nums.length) {
//            nums[i++] = 0;
//        }
//
//        return nums;
    }
}
