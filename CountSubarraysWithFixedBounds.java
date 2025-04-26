class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans=0;
        int lastMinK=-1, lastMaxK=-1, lastBad=-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<minK || nums[i]>maxK){
                lastBad=i;
            }
            if(nums[i]==minK){
                lastMinK=i;
            }
            if(nums[i]==maxK){
                lastMaxK=i;
            }
            int validStart=Math.min(lastMinK, lastMaxK);
            if(validStart>lastBad){
                ans+=(validStart-lastBad);
            }
        }
        return ans;
    }
}