class Solution {
    public int maxDistance(String s, int k) {
       int north=0, south=0, west=0, east=0;
       int ans=0;
       for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
        if(c=='N') north++;
        else if (c=='S') south++;
        else if (c=='W') west++;
        else if (c=='E') east++;

        int MD = Math.abs(north-south) + Math.abs(east-west);
        int dis = MD + Math.min(2*k, i+1-MD);
        ans = Math.max(ans, dis);    
       } 
       return ans;
    }
}