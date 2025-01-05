import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int countPalindromicSubsequence(String s) {
        // Step 1: Store the first and last occurrence of each character
        HashMap<Character, int[]> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new int[]{-1, -1});
        }

        int n = s.length();
        // Fill first occurrence
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.get(c)[0] == -1) {
                map.get(c)[0] = i;
            }
        }

        // Fill last occurrence
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (map.get(c)[1] == -1) {
                map.get(c)[1] = i;
            }
        }

        // Step 2: Count unique characters between first and last occurrence
        int count = 0;
        for (char c : map.keySet()) {
            int start = map.get(c)[0];
            int end = map.get(c)[1];

            if (start != -1 && end != -1 && start < end) {
                HashSet<Character> uniqueChars = new HashSet<>();
                for (int i = start + 1; i < end; i++) {
                    uniqueChars.add(s.charAt(i));
                }
                count += uniqueChars.size();
            }
        }

        return count;
    }
}
