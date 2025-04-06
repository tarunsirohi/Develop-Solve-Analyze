class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int [] dp = new int [nums.length];
        int [] prev = new int [nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);
        int maxi=0;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            if(dp[i]>dp[maxi]) maxi=i;
        }
        List<Integer> res=new ArrayList<>();
        int i=maxi;
        while(i>=0){
            res.add(nums[i]);
            if(prev[i]==-1) break;
            i=prev[i];
        }
        return res;
    }
}