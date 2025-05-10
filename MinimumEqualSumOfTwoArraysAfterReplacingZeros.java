class Solution {
    public long minSum(int[] nums1, int[] nums2) {  
        long sum1=0, sum2=0;
        int zero1=0, zero2=0;
        for(int num:nums1){
            if(num==0) zero1++;
            else sum1+=num;
        }
        for(int num:nums2){
            if(num==0) zero2++;
            else sum2+=num;
        }
        long minSum1= sum1+zero1;
        long minSum2= sum2+zero2;
        if(zero1==0 && zero2==0 && sum1!=sum2) return -1;
        if(sum1<minSum2 && zero1==0) return -1;
        if(sum2<minSum1 && zero2==0) return -1;
        return Math.max(minSum1, minSum2);
    }
}