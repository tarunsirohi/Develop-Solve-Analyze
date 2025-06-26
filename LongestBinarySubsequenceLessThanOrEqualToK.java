class Solution {
    public int longestSubsequence(String s, int k) {
        int length =0, power=0;
        long value=0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i)=='0'){
                length++;
            }
            else{
                if(power < 32 && value + (1L<<power) <= k){
                    value += (1L<<power);
                    length++;
                }
            }
            if(power<32) power++;
        }
        return length;
    }
}