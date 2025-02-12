class Solution {
    public int sumOfDigits(int num){
        int sum=0;
        while(num>0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        Map <Integer, Integer> sumMaxVal = new HashMap<>();
        int maxSum=-1;
        for(int ele:nums){
            int digitSum= sumOfDigits(ele);
            if (sumMaxVal.containsKey(digitSum)){
                maxSum = Math.max( maxSum, ele + sumMaxVal.get(digitSum));
                if (sumMaxVal.get(digitSum)<ele){
                    sumMaxVal.put(digitSum, ele);
                }
            }
            else{
                sumMaxVal.put(digitSum, ele);
            }
        }
        return maxSum;
    }
}