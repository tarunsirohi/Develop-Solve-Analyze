class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set <Integer> result = new HashSet<>();
        int n = digits.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(i==j || j==k || k==i) continue;
                    if(digits[i]==0 || digits[k] % 2 != 0) continue;
                    int num = digits[i]*100 + digits[j]*10 + digits[k];
                    result.add(num);
                }
            }
        }
        List <Integer> list = new ArrayList<>(result);
        Collections.sort(list);
        int [] output = new int [list.size()];
        for(int i=0; i<list.size(); i++){
            output[i] = list.get(i);
        }
        return output;
    }
}