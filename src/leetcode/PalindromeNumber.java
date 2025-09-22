package leetcode;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1101011));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String number = String.valueOf(x);
        int length = number.length();
        for (int i = 0; i < length / 2; i++) {
            if (number.charAt(i) != number.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
