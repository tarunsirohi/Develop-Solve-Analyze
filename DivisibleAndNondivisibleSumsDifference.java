class Solution {
    public int differenceOfSums(int n, int m) {
        int sum1=0, sum2=0;
        int [] nums1 = new int [n+1];
        int [] nums2 = new int [n+1];
        for(int i=1; i<n+1; i++){
            if(i%m != 0){
                nums1 [i] = i;
                sum1 += nums1[i];
            }  
            else{
                nums2 [i] = i;
                sum2 += nums2[i];
            }  
        }
        return sum1-sum2;
    }
}