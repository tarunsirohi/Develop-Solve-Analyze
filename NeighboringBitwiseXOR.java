class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int result=0;
        for( int element : derived) {
            result^=element;
        }
        return result==0;
    }
}