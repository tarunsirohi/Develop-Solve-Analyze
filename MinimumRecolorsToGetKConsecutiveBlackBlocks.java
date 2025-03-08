class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static int minimumRecolors(String blocks, int k) {
        int whiteCount=0;
        int minRecolor = Integer.MAX_VALUE;

        for(int i=0; i<k; i++){
            if(blocks.charAt(i)=='W') whiteCount++;
        }
        minRecolor = whiteCount;

        for(int i=k; i<blocks.length(); i++){
            if(blocks.charAt(i-k)=='W') whiteCount--;
            if(blocks.charAt(i)=='W') whiteCount++;
            minRecolor = Math.min( minRecolor, whiteCount);
        }
        return minRecolor;
    }
    public static void main(String[] args) {
        System.out.println(minimumRecolors("BBWBWBWB", 3));
    }
}