package leetcode;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "[";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int[] ans = new int[s.length()];
        int total = -1;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ans[++total] = ')';
            } else if (c == '{') {
                ans[++total] = '}';
            } else if (c == '[') {
                ans[++total] = ']';
            } else if (total == -1 || ans[total--] != c) {
                return false;
            }
        }
        return total == -1;
    }
}
