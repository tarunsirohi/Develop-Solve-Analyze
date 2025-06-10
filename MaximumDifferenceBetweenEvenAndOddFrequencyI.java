class Solution {
    public int maxDifference(String s) {
        Map <Character, Integer> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c,0)+1);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int f : freq.values()){
            if(f%2!=0){
                max = Math.max(max,f);
            }
            else {
                min = Math.min(min,f);
            }
        }
        return (max-min);
    }
}