class Solution {
    public boolean divideArray(int[] nums) {
        int []freq= new int[501];
        for(int num:nums){
            freq[num]++;
        }
        for(int count:freq){
            if(count%2!=0){
                return false;
            }
        }
    // OR    
    // HashMap <Integer, Integer> freq = new HashMap <>();
    // for(int num:nums){
    //     freq.put(num, freq.getOrDefault(num, 0)+1);
    // }
    // for(int count:freq.values()){
    //     if(count%2!=0) return false;
    // }
    return true;
    }
}