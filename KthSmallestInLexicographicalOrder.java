class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k-=1;
        while(k>0){
            long steps = countPrefix(n, curr, curr+1);
            if(steps<=k){
                curr += 1;
                k-=steps;
            }
            else{
                curr*=10;
                k-=1;
            }
        }
        return curr;
    }
    private long countPrefix(int n, long prefix, long nextPrefix){
        int steps=0;
        while(prefix<=n){
            steps += Math.min(n+1,nextPrefix)-prefix;
            prefix*=10;
            nextPrefix*=10;
        }
        return steps;
    }
}