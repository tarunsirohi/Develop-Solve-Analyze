class Solution {
    public int countLargestGroup(int n) {
        Map <Integer, Integer> digitSumMap = new HashMap<>();
        for(int i=1; i<=n; i++){
            int sum = getDigitSum(i);
            digitSumMap.put(sum, digitSumMap.getOrDefault(sum,0)+1);
        }
        int maxSize=0;
        for(int size : digitSumMap.values()){
            if(size>maxSize){
                maxSize=size;
            }
        }
        int groups=0;
        for(int size : digitSumMap.values()){
            if(size==maxSize){
                groups++;
            }
        }
        return groups;
    }
    private int getDigitSum(int num){
        int sum=0;
        while(num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}