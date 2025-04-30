class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int num:nums){
            int length = countDigit(num);
            if(length % 2==0) count++;
        }
        return count;
    }
    private int countDigit(int n){
        int length=0;
        while(n>0){
            n=n/10;
            length++;
        }
        return length;
    }
}