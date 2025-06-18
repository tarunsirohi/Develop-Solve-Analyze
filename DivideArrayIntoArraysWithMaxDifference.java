class Solution {
    public int[][] divideArray(int[] nums, int k) {
        List<List<Integer>>list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i+=3){
            if(nums[i+2]-nums[i]<=k){
                List <Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(nums[i+1]);
                triplet.add(nums[i+2]);
                list.add(triplet);
            }
            else{
                return new int[0][0];
            }
        }
        int [][]result = new int[list.size()][3];
        for(int i=0; i<list.size(); i++){
            List <Integer> triplet = list.get(i);
            for(int j=0; j<3; j++){
                result[i][j] = triplet.get(j);
            }
        }
        return result;
    }
}