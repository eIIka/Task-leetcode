package leetcode;

public class DivideArrayIntoEqualPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,2,2,2};

        System.out.println(divideArray(nums));
    }

    private static boolean divideArray(int[] nums) {
        int[] equalPairs = new int[501];

        for (int num : nums) {
            equalPairs[num]++;
        }

        for (int equalPair : equalPairs) {
            if (equalPair % 2 != 0) {
                return false;
            }
        }
        return true;

//        if (nums.length % 2 != 0) {
//            return false;
//        }
//
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length; i += 2) {
//            if (nums[i] != nums[i + 1]) {
//                return false;
//            }
//        }
//        return true;
    }
}
