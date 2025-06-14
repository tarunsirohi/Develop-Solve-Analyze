class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        char replaceToMax = ' ';
        for(char c : numStr.toCharArray()){
            if(c != '9'){
                replaceToMax = c;
                break;
            }
        }
        String maxStr = remapDigit(numStr, replaceToMax, '9');
        int maxVal = Integer.parseInt(maxStr);

        char replaceToMin = ' ';
        for(char c : numStr.toCharArray()){
            if(c != '0'){
                replaceToMin = c;
                break;
            }
        }
        String minStr = remapDigit(numStr, replaceToMin, '0');
        int minVal = Integer.parseInt(minStr);

        return maxVal - minVal;
    }
    private String remapDigit(String numStr, char from, char to){
        StringBuilder result = new StringBuilder();
        for(char c : numStr.toCharArray()){
            if(c == from) result.append(to);
            else result.append(c);
        }
        return result.toString();
    }
}