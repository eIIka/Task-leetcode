package leetcode;

import java.util.Arrays;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int[] nums = {5,0,1,2,3,4};
        System.out.println(Arrays.toString(buildArray(nums)));
    }

    public static int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}
