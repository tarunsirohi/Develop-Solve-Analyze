class Solution {
    public int waysToSplitArray(int[] nums) {
       long leftSum=0, totalSum=0;
       for (int num : nums) {
        totalSum += num;
       }
       int count=0;
       for (int i=0; i<nums.length-1; i++){
        leftSum += nums[i];
        totalSum -= nums[i];
        if (leftSum>=totalSum){
            count++;
        }
       }
       return count;
    }
}