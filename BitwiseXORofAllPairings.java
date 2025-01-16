class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;

        // Find contribution by first array elements
        int m = nums2.length;
        if ((m & 1) == 1) {
            for (int ele : nums1) {
                ans ^= ele;
            }
        }

        // Find contribution by second array elements
        int n = nums1.length;
        if ((n & 1) == 1) {
            for (int ele : nums2) {
                ans ^= ele;
            }
        }
        return ans;
    }
}