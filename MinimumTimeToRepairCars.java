class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left=1, right = (long)ranks[0]*cars*cars;
        while(left<right){
            long mid = left + (right-left)/2;
            if(canRepair(ranks, cars, mid)){
                right = mid;
            }
            else left = mid+1;
        }
        return left;
    }
    private static boolean canRepair (int [] ranks, int cars, long time){
        int totalCars=0;
        for (int r : ranks){
            totalCars += (long) Math.sqrt(time/r);
            if (totalCars >= cars) return true;
        }
        return false;
    }
}