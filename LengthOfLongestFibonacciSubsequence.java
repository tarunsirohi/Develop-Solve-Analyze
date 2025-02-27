public int lenLongestFibSubseqDP(int[] arr) {
    int n = arr.length;
    int[][] dp = new int[n][n];
    int longest = 0;

    for (int sum = 2; sum < n; sum++) {
        int a = 0;
        int b = sum - 1;
        while (a < b) {
            if (arr[a] + arr[b] < arr[sum]) {
                a++;
            } else if (arr[a] + arr[b] > arr[sum]) {
                b--;
            } else {
                dp[b][sum] = 1 + dp[a][b];
                longest = Math.max(longest, dp[b][sum]);
                a++;
                b--;
            }
        }
    }
    return longest == 0 ? 0 : 2 + longest;
}