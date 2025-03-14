class Solution {
    public int maximumCandies(int[] candies, long k) {
        if (k == 0) return 0;
        int left = 1, right = 0;
        for (int candy : candies){
            right = Math.max( candy, right);
        }
        int result =0;
        while (left<=right){
            int mid = left + (right - left)/2;
            if( canDistribute(candies, k, mid)){
                result = mid;
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return result;
    }
    private static boolean canDistribute(int [] candies, long k, int x){
        if (x==0) return false;
        long count =0;
        for(int candy : candies){
            count += candy/x;
            if (count>=k) return true;
        }
        return count>=k;
    }
}