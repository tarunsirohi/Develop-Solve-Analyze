class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int longest=1;
        int strictly_inc=1;
        int strictly_dec=1;
        for (int i=1; i<n; i++){

            if (nums[i]>nums[i-1]){
                strictly_inc++;
                strictly_dec=1;
            } 
            else if (nums[i]<nums[i-1]){
                strictly_dec++;
                strictly_inc=1;
            } 
            else{
                strictly_dec=1;
                strictly_inc=1;
            } 

            longest = Math.max(longest, Math.max(strictly_inc, strictly_dec));
        }
        return longest;
    }
}