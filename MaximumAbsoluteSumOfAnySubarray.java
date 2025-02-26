class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min_prefixSum = 0, max_prefixSum = 0, prefixSum = 0;
        for (int ele : nums){
            prefixSum += ele;
            min_prefixSum = Math.min(prefixSum, min_prefixSum);
            max_prefixSum = Math.max(prefixSum, max_prefixSum);
        }
        return max_prefixSum - min_prefixSum;
    }
}