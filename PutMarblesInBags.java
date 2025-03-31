class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if(k==1) return 0;
        List <Integer> pairSum = new ArrayList<>();
        for(int i=0; i<n-1; i++){
            pairSum.add(weights[i] + weights[i+1]);
        }
        Collections.sort(pairSum);
        long maxScore = 0, minScore=0;
        for(int i=0; i<k-1; i++){
            minScore += pairSum.get(i);
            maxScore += pairSum.get(pairSum.size()-1-i);
        }
        return maxScore - minScore;
    }
}