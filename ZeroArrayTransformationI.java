class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int [] diff = new int [nums.length + 1];
        for (int [] query : queries){
            diff[query[0]] += 1;
            diff[query[1]+1] -= 1;
        }
        int [] coverage = new int [nums.length];
        int curr = 0;
        for(int i=0; i<nums.length; i++){
            curr += diff[i];
            coverage[i] = curr;
        }
        for(int i=0; i<nums.length; i++){
            if(coverage[i]<nums[i]) return false;
        }
        return true;
    }
}