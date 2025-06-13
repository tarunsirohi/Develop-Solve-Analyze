class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p==0) return 0;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[nums.length-1]-nums[0];
        while(low <= high){
            int mid = (low+high)/2;
            if(canFormPairs(nums, p, mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    private boolean canFormPairs(int[] nums, int p, int maxDiff){
        int count=0;
        for(int i=0; i<nums.length-1;){
            if(nums[i+1]-nums[i]<=maxDiff){
                count++;
                i+=2;
            }
            else{
                i++;
            }
            if(count>=p){
                return true;
            } 
        }
        return false;
    }
}