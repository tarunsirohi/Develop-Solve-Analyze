class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n=nums.length;
        int max_diff=0;
        for (int i=0; i<n; i++){
            int diff = Math.abs(nums[i]-nums[(i+1)%n]);
            max_diff= Math.max(max_diff,diff);
        }
        return max_diff;
    }
}