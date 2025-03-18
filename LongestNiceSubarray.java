class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int left=0, right=0;
        int currSum=0, xorSum=0;
        int maxWindowSize=0;

        while(right<n){
            currSum += nums[right];
            xorSum ^= nums[right];
            while(currSum != xorSum){
                currSum -= nums[left];
                xorSum ^= nums[left];
                left++;
            }
            maxWindowSize = Math.max(maxWindowSize, right-left+1);
            right++;
        }
        return maxWindowSize;
    }
}