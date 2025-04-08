class Solution {
    public int minimumOperations(int[] nums) {
        List <Integer> list = new ArrayList<>();
        for (int n : nums){
            list.add(n);
        }
        int operations=0;
        while(true){
            Set <Integer> set = new HashSet<>(list);
            if(set.size()==list.size()) break;
            int removeCount = Math.min(3,list.size());
            for(int i=0; i<removeCount; i++){
                list.remove(0);
            }
            operations++;
        }
        return operations;
    }
}