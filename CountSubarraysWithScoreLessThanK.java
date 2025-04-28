class Solution {
    public long countSubarrays(int[] nums, long k) {
       long n = nums.length;
       int left=0;
       long windowSum=0;
       long result=0;
       for(int right=0; right<n; right++){
        windowSum+=nums[right];
        while(left<=right && windowSum*(right-left+1)>=k){
            windowSum-=nums[left];
            left++;
        }
        result+=right-left+1;
       } 
       return result;
    }
}