class Solution {
    private int buildString(int[] freq) {
        int ways = 0;
        // Try placing each character at the current position
        for (int i = 0; i < 26; ++i) {
            if (freq[i] > 0) { // If the character is available
                freq[i]--; // Use the character once
                ways += 1 + buildString(freq); // Count this combination and recurse
                freq[i]++; // Restore the character for other combinations
            }
        }
        return ways;
    }

    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        // Count the frequency of each character
        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }
        return buildString(freq);
    }
}
