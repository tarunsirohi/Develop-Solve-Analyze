class Solution {
    public int minCapability(int[] nums, int k) {
        int left=1, right=0;
        for (int num : nums){
            right = Math.max(right, num);
        }
        while(left<right){
            int mid = left + (right-left)/2;
            if (canRob(nums, k, mid)){
                right=mid;
            }
            else left=mid+1;
        }
        return left;
    }
    private static boolean canRob(int [] nums, int k, int maxCap){
        int count=0, i=0;
        while (i<nums.length){
            if(nums[i]<=maxCap){
                count++;
                i++;
            }
            i++;
        } 
        return count>=k;
    }
}