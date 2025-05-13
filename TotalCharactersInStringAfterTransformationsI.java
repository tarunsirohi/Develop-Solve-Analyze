public class Solution {
    private static final int MOD = 1_000_000_007;

    private int addMod(int a, int b) {
        a += b;
        if (a >= MOD) a -= MOD;
        return a;
    }

    public int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        while (t-- > 0) {
            int[] next = new int[26];
            for (int j = 0; j < 26; j++) {
                if (j < 25) {
                    next[j + 1] = freq[j];
                } else {
                    // 'z' → 'a' and also contributes to 'b'
                    next[0] = freq[25];
                    next[1] = addMod(next[1], freq[25]);
                }
            }
            freq = next;
        }

        int result = 0;
        for (int x : freq) {
            result = addMod(result, x);
        }
        return result;
    }
}
