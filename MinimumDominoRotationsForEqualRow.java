class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops[0],tops,bottoms);
        if(result!=-1||tops[0]==bottoms[0]) return result;
        return check(bottoms[0],tops,bottoms);
    }
    private int check(int target,int []tops, int []bottoms){
        int topRotations=0, bottomRotations=0;
        for(int i=0; i<tops.length; i++){
            if(tops[i]!=target && bottoms[i]!=target) return -1;
            if(tops[i]!=target) topRotations++;
            if(bottoms[i]!=target) bottomRotations++;
        }
        return Math.min(topRotations, bottomRotations);
    }
}