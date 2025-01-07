class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length(); // Get the length of the string.
        int[] res = new int[n]; // Array to store the result.

        int moves = 0; // Accumulate moves for left-to-right pass.
        int count = 0; // Count of '1's seen so far.
        
        // First pass: Calculate moves for each box from left to right.
        for (int i = 0; i < n; i++) {
            res[i] = moves; // Set current moves for the box.
            if (boxes.charAt(i) == '1') {
                count++; // Increment count if the current box has a ball.
            }
            moves += count; // Add count to moves for the next box.
        }
        
        moves = 0; // Reset moves for right-to-left pass.
        count = 0; // Reset count of '1's seen.

        // Second pass: Calculate moves for each box from right to left.
        for (int i = n - 1; i >= 0; i--) {
            res[i] += moves; // Add current moves to the result.
            if (boxes.charAt(i) == '1') {
                count++; // Increment count if the current box has a ball.
            }
            moves += count; // Add count to moves for the next box.
        }
        
        return res; // Return the final result array.
    }
}
