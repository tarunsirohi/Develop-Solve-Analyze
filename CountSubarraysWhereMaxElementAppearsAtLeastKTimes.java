class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int maxVal=0;
        for(int num:nums){
            maxVal=Math.max(maxVal,num);
        }
        int left=0;
        long count=0;
        int freq=0;
        for(int right=0; right<n; right++){
            if(nums[right]==maxVal) freq++;
            while(freq>=k){
                count+=n-right;
                if(nums[left]==maxVal) freq--;
                left++;
            }
        }
        return count;
    }
}