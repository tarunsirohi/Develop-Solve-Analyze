class Solution {
    public String shiftingLetters(String s, int[][] shifts) { 
        int n = s.length();
        int[] diff = new int[n + 1];
        // Apply shifts using the difference array
        for (int[] shift : shifts) {
            if (shift[2] == 1) { // Right shift
                diff[shift[0]] += 1; // Start of right shift
                diff[shift[1] + 1] -= 1; // Neutralize after the range
            } else { // Left shift
                diff[shift[0]] -= 1; // Start of left shift
                diff[shift[1] + 1] += 1; // Neutralize after the range
            }
        }
        // Calculate the cumulative shift and update characters
        int shiftSum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            shiftSum = (shiftSum + diff[i]) % 26; // Cumulative shift
            if (shiftSum < 0) shiftSum += 26; // Ensure non-negative shift
            chars[i] = (char) ('a' + (chars[i] - 'a' + shiftSum) % 26); // Apply shift
        }
        return new String(chars);
    }
}

