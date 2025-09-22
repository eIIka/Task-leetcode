package leetcode;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[] {2,7,11,15};

        System.out.println(Arrays.toString(twoSum(arr, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] + nums[i + 1] == target){
                arr[0] = i;
                arr[1] = i + 1;
                return arr;
            }
        }
        return null;
    }
}