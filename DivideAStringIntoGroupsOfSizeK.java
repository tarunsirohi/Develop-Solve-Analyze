class Solution {
    public String[] divideString(String s, int k, char fill) {
       List<String> list = new ArrayList<>();
       for(int i=0; i<s.length(); i+=k){
        if(i+k<=s.length()){
            list.add(s.substring(i,i+k));
        }
        else{
            StringBuilder lastGroup = new StringBuilder(s.substring(i));
            int fillCount = k-(s.length()-i);
            for(int j=0; j<fillCount; j++){
                lastGroup.append(fill);
            }
            list.add(lastGroup.toString());
        }
       } 
       return list.toArray(new String[0]);
    }
}