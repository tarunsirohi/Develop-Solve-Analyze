class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List <String> list = new ArrayList<>();
        list.add(words[0]);
        int prevGroup = groups[0];
        for(int i=1; i<groups.length; i++){
            if(groups[i] != prevGroup){
                list.add(words[i]);
                prevGroup = groups[i];
            }
        }
        return list;
    }
}