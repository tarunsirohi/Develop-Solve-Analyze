class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int oddCount = 0;
        int evenCount = 1; // Prefix sum of 0 is even
        int total = 0;
        int prefixSum = 0;

        for (int ele : arr) {
            prefixSum += ele;
            if ((prefixSum & 1) == 1) { // If prefix sum is odd
                total = (total + evenCount) % MOD;
                oddCount++;
            } else { // If prefix sum is even
                total = (total + oddCount) % MOD;
                evenCount++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 3, 5}; // Example input
        System.out.println(solution.numOfSubarrays(arr)); // Output: 4
    }
}