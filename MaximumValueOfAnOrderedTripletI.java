class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    res = Math.max(res, (long)(nums[i]-nums[j])*nums[k]);
                }
            }
        }
        return res;
    }
}
