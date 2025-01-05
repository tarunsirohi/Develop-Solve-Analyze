class Solution {
    public int maxScore(String s) {
        int zero=0, one=0, n=s.length(), ans=Integer.MIN_VALUE;
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)=='1'){
                one++;
            }
            else{
                zero++;
            }
            ans=Math.max(ans, zero-one);
        }
        if(s.charAt(n-1)=='1'){
            one++;
        }
        return ans=ans+one;
    }
}
