class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()){
            freq[c-'a']++;
        }

        int len=0;
        for (int count : freq){
            if (count%2 == 1) len++;
            else len += Math.min(2,count);
        }
        return len;
    }
}