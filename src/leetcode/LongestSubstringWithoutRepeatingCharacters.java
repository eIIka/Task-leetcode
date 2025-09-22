package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder longestSubstring = new StringBuilder();

        for (char c : s.toCharArray()) {
            String charStr = String.valueOf(c);
            int index = longestSubstring.indexOf(charStr);

            if (index != -1) {
                longestSubstring.delete(0, index + 1);
            }

            longestSubstring.append(charStr);
            maxLength = Math.max(maxLength, longestSubstring.length());
        }
        return maxLength;
    }
}
