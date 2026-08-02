package Array;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty())
            return "";

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = freq.size(), left = 0;
        int[] res = new int[] { -1, -1 };
        int len = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            window.put(current, window.getOrDefault(current, 0) + 1);

            if (freq.containsKey(current)
                    && window.get(current).intValue() == freq.get(current).intValue()) {
                have++;
            }

            while (have == need) {
                if (right - left + 1 < len) {
                    res[0] = left;
                    res[1] = right;
                    len = right - left + 1;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if (freq.containsKey(leftChar) && window.get(leftChar) < freq.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }

        return len != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }
}
